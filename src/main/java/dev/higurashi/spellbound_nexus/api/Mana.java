package dev.higurashi.spellbound_nexus.api;

import dev.higurashi.spellbound_nexus.common.capabilities.IManaCapability;
import dev.higurashi.spellbound_nexus.common.network.ManaSyncS2CPacket;
import dev.higurashi.spellbound_nexus.common.network.PacketHandler;
import dev.higurashi.spellbound_nexus.registries.CapabilityRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;

public class Mana {
    private static LazyOptional<IManaCapability> getCapability(Player player) {
        return player.getCapability(CapabilityRegistry.MANA_CAPABILITY);
    }

    // === Add Mana ===
    public static void add(Player player, float amount) {
        set(player, get(player) + amount);
    }

    // === Consume Mana ===
    public static ManaResult consume(Player player, float amount) {
        float currentMana = get(player);
        if (currentMana >= amount) {
            set(player, currentMana - amount);
            return new ManaResult(true, currentMana - amount);
        }
        return new ManaResult(false, currentMana);
    }

    // === Set Mana ===
    public static void set(Player player, float amount) {
        getCapability(player).ifPresent(mana -> {
            mana.setMana(amount);

            if (player instanceof ServerPlayer serverPlayer) sync(serverPlayer);
        });
    }

    // == Get Current Mana ===
    public static float get(Player player) {
        return getCapability(player).map(IManaCapability::getMana).orElse(0f);
    }

    // === Get Max Mana ===
    public static float getMax(Player player) {
        return getCapability(player).map(IManaCapability::getMaxMana).orElse(0f);
    }

    public static void sync(ServerPlayer player) {
        getCapability(player).ifPresent(mana -> {
            PacketHandler.sendToPlayer(new ManaSyncS2CPacket(mana.getMana()), player);
        });
    }

    public record ManaResult(boolean success, float currentMana) {
        public void ifFailed(Player player, String message) {
            if (!success) {
                player.displayClientMessage(Component.literal(message), true);
            }
        }
    }
}
