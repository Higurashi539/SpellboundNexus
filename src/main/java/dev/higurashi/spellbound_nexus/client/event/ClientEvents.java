package dev.higurashi.spellbound_nexus.client.event;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import dev.higurashi.spellbound_nexus.client.gui.ManaHudOverlay;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpellboundNexus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onRegisterGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("mana_hud", ManaHudOverlay.HUD_MANA);
    }
}
