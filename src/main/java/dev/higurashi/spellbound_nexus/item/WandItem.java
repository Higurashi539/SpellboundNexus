package dev.higurashi.spellbound_nexus.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class WandItem extends Item {
    public WandItem() {
        super(new Properties().rarity(Rarity.RARE).stacksTo(1));
    }

    public void initWandNbt(ItemStack stack) {
        CompoundTag nbt = stack.getOrCreateTag();
        nbt.putString("wood", "oak");
        nbt.putString("gem", "ruby");
        nbt.putString("grip", "iron");
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.spellbound_nexus.parts.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int id, boolean selected) {
        CompoundTag nbt = stack.getOrCreateTag();
        if (!nbt.contains("wood", CompoundTag.TAG_STRING) || !nbt.contains("gem", CompoundTag.TAG_STRING) || !nbt.contains("grip", CompoundTag.TAG_STRING)) {
            initWandNbt(stack);
        }
    }
}
