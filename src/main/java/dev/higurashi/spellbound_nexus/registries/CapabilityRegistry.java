package dev.higurashi.spellbound_nexus.registries;

import dev.higurashi.spellbound_nexus.common.capabilities.IManaCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class CapabilityRegistry {
    public static final Capability<IManaCapability> MANA_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
}
