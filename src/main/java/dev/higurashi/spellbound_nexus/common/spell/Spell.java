package dev.higurashi.spellbound_nexus.common.spell;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Spell {
    private final String name;
    private final float manaCost;

    public Spell(String name, float manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }

    public abstract void cast(Level level, Player player);

    public String getName() { return name; }
    public float getManaCost() { return manaCost; }
}
