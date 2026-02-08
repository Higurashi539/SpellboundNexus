package dev.higurashi.spellbound_nexus.common.event;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import dev.higurashi.spellbound_nexus.api.Mana;
import dev.higurashi.spellbound_nexus.common.capabilities.IManaCapability;
import dev.higurashi.spellbound_nexus.common.capabilities.ManaCapabilityProvider;
import dev.higurashi.spellbound_nexus.registries.AttributeRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpellboundNexus.MOD_ID)
public class ManaEventHandler {
    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {
        event.register(IManaCapability.class);
    }

    @SubscribeEvent
    public static void attachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof LivingEntity entity) {
            ManaCapabilityProvider provider = new ManaCapabilityProvider(entity);
            event.addCapability(ResourceLocation.fromNamespaceAndPath(SpellboundNexus.MOD_ID, "mana"), provider);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!player.level().isClientSide() && event.phase == TickEvent.Phase.END) {
            if (player.tickCount % 20 == 0) {
                float regenAmount = (float) player.getAttributeValue(AttributeRegistry.MANA_REGEN.get());
                Mana.add(player, regenAmount);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            player.getServer().execute(() -> {
                Mana.sync(player);
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
//        event.getOriginal().getCapability(CapabilityRegistry.MANA_CAPABILITY).ifPresent(oldCap -> {
//            event.getEntity().getCapability(CapabilityRegistry.MANA_CAPABILITY).ifPresent(newCap -> {
//                newCap.setMana(oldCap.getMaxMana());
//            });
//        });
    }
}
