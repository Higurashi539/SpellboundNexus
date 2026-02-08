package dev.higurashi.spellbound_nexus.common.capabilities;

import dev.higurashi.spellbound_nexus.registries.CapabilityRegistry;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ManaCapabilityProvider implements ICapabilitySerializable<CompoundTag> {
    private final ManaCapability instance;
    private final LazyOptional<IManaCapability> optionalData;

    public ManaCapabilityProvider(LivingEntity entity) {
        this.instance = new ManaCapability(entity);
        this.optionalData = LazyOptional.of(() -> instance);
    }


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return CapabilityRegistry.MANA_CAPABILITY.orEmpty(cap, this.optionalData);
    }

    @Override
    public CompoundTag serializeNBT() {
        return instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        instance.deserializeNBT(nbt);
    }
}
