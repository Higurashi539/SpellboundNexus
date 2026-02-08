package dev.higurashi.spellbound_nexus.common.spell.fire;

import dev.higurashi.spellbound_nexus.common.spell.Spell;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;

public class FireBallSpell extends Spell {
    public FireBallSpell() {
        super("fireball", 20.0f);
    }

    @Override
    public void cast(Level level, Player player) {
        SmallFireball fireball = new SmallFireball(level, player, player.getLookAngle().x,  player.getLookAngle().y, player.getLookAngle().z);
        fireball.setPos(player.getX(), player.getEyeY(), player.getZ());
        level.addFreshEntity(fireball);

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
    }
}
