package dev.higurashi.spellbound_nexus.common.client;

import dev.higurashi.spellbound_nexus.registries.CapabilityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ManaSyncS2CPacket {
    private float mana;

    public ManaSyncS2CPacket(FriendlyByteBuf buf) {
        this.mana = buf.readFloat();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeFloat(mana);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        NetworkEvent.Context context = ctx.get();
        context.enqueueWork(() -> {
            LocalPlayer player = Minecraft.getInstance().player;

            if (player != null) {
                player.getCapability(CapabilityRegistry.MANA_CAPABILITY).ifPresent(mana -> {
                    mana.setMana(this.mana);
                });
            }
        });
        context.setPacketHandled(true);
    }
}
