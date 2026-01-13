package dev.higurashi.spellbound_nexus.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue USE_ANIMATION;

    static {
        BUILDER.push("Client");
        USE_ANIMATION = BUILDER.comment("Use Player Animation. Default: true").define("use_animation", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
