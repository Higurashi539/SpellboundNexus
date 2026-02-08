package dev.higurashi.spellbound_nexus.common.capabilities;

import dev.higurashi.spellbound_nexus.registries.CapabilityRegistry;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ManaCapabilityProvider implements ICapabilitySerializable<CompoundTag> {
    private final LazyOptional<IManaCapability> optionalData = LazyOptional.of(() -> new ManaCapability(null));

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return CapabilityRegistry.MANA_CAPABILITY.orEmpty(cap, this.optionalData);
    }

    @Override
    public CompoundTag serializeNBT() {
        return optionalData.map(INBTSerializable::serializeNBT).orElse(new CompoundTag());
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        optionalData.ifPresent(cap -> cap.deserializeNBT(nbt));
    }
}
