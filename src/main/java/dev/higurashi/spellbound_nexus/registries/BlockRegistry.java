package dev.higurashi.spellbound_nexus.registries;

import dev.higurashi.spellbound_nexus.SpellboundNexus;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SpellboundNexus.MOD_ID);
    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
