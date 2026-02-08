package dev.higurashi.spellbound_nexus.registries;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import dev.higurashi.spellbound_nexus.common.spell.Spell;
import dev.higurashi.spellbound_nexus.common.spell.fire.FireBallSpell;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SpellRegistry {
    public static final DeferredRegister<Spell> SPELLS = DeferredRegister.create(ResourceLocation.fromNamespaceAndPath(SpellboundNexus.MOD_ID, "spells"), SpellboundNexus.MOD_ID);
    public static void register(IEventBus eventBus) { SPELLS.register(eventBus); }

    public static final RegistryObject<Spell> FIREBALL = SPELLS.register("fireball", FireBallSpell::new);
}
