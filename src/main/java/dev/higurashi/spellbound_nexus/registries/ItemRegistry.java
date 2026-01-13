package dev.higurashi.spellbound_nexus.registries;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpellboundNexus.MOD_ID);
    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
