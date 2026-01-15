package dev.higurashi.spellbound_nexus.common.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IManaCap extends INBTSerializable<CompoundTag> {
    float getMana();
    void setMana(float value);
    float getMaxMana();
    void setMaxMana(float value);
}
