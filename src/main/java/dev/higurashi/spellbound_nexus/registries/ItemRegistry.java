package dev.higurashi.spellbound_nexus.registries;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import dev.higurashi.spellbound_nexus.item.WandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpellboundNexus.MOD_ID);
    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }

    public static final RegistryObject<Item> WOODEN_WAND = ITEMS.register("wooden_wand", WandItem::new);
}
