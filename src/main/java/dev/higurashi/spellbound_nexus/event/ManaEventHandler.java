package dev.higurashi.spellbound_nexus.event;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import dev.higurashi.spellbound_nexus.common.capabilities.IManaCapability;
import dev.higurashi.spellbound_nexus.common.capabilities.ManaCapabilityProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
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
        if (event.getObject() instanceof LivingEntity) {
            ManaCapabilityProvider provider = new ManaCapabilityProvider();
            event.addCapability(ResourceLocation.fromNamespaceAndPath(SpellboundNexus.MOD_ID, "mana"), provider);
        }
    }
}
