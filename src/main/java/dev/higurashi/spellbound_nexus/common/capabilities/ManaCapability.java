package dev.higurashi.spellbound_nexus.common.capabilities;

import dev.higurashi.spellbound_nexus.registries.AttributeRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

public class ManaCapability implements IManaCapability {
    float mana;
    LivingEntity entity;

    public ManaCapability(LivingEntity entity) {
        this.entity = entity;
        this.mana = 0;
    }

    @Override
    public float getMana() {
        return this.mana;
    }

    @Override
    public void setMana(float value) {
        this.mana = Math.max(0, Math.min(value, getMaxMana()));
    }

    @Override
    public float getMaxMana() {
        if (entity == null) return 0.0f;
        return (float) entity.getAttributeValue(AttributeRegistry.MAX_MANA.get());
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("mana", getMana());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.mana = tag.getFloat("mana");
    }
}
