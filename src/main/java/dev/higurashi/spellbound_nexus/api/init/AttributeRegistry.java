package dev.higurashi.spellbound_nexus.api.init;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SpellboundNexus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeRegistry {
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, SpellboundNexus.MOD_ID);
    public static void register(IEventBus eventBus) { ATTRIBUTES.register(eventBus); }

    public static final RegistryObject<Attribute> MAX_MANA = ATTRIBUTES.register("max_mana", () -> (new RangedAttribute("attribute.spellbound_nexus.max_mana", 0.0D, 0.0D, 100000000.0D).setSyncable(true)));
    public static final RegistryObject<Attribute> MANA_REGEN = ATTRIBUTES.register("mana_regen", () -> (new RangedAttribute("attribute.spellbound_nexus.mana_regen", 1.0D, 0.0D, 10000.0D).setSyncable(true)));

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> event.add(entity, attribute.get())));
    }
}
