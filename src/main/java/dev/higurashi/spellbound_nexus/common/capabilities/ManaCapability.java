package dev.higurashi.spellbound_nexus.common.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

public class ManaCapability implements IManaCap {
    float mana;
    float maxMana;
    LivingEntity entity;

    public ManaCapability(LivingEntity entity) {
        this.mana = 0;
        this.maxMana = 100;
        this.entity = entity;
    }

    @Override
    public float getMana() {
        return this.mana;
    }

    @Override
    public void setMana(float value) {
        this.mana = Math.max(0, Math.min(value, this.maxMana));
    }

    @Override
    public float getMaxMana() {
        return maxMana;
    }

    @Override
    public void setMaxMana(float value) {
        this.maxMana = Math.max(0, value);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("mana", getMana());
        tag.putFloat("max_mana", getMaxMana());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        setMana(tag.getFloat("mana"));
        setMaxMana(tag.getFloat("max_mana"));
    }
}
