package dev.higurashi.spellbound_nexus.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Common");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
