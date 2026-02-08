package dev.higurashi.spellbound_nexus.common.item;

import dev.higurashi.spellbound_nexus.api.Mana;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class WandItem extends Item {
    public WandItem() {
        super(new Properties().rarity(Rarity.RARE).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Mana.ManaResult result = Mana.consume(player, 20.0f);
            result.ifFailed(player, "マナが足りません");

            if (result.success()) {
                SmallFireball fireball = new SmallFireball(level, player, player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z);

                fireball.setPos(player.getX(), player.getEyeY(), player.getZ());

                level.addFreshEntity(fireball);

                level.playSound(null, player.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);

                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    public void initWandNbt(ItemStack stack) {
        CompoundTag nbt = stack.getOrCreateTag();
        nbt.putString("wood", "oak");
        nbt.putString("gem", "ruby");
        nbt.putString("grip", "iron");
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int id, boolean selected) {
        CompoundTag nbt = stack.getOrCreateTag();
        if (!nbt.contains("wood", CompoundTag.TAG_STRING) || !nbt.contains("gem", CompoundTag.TAG_STRING) || !nbt.contains("grip", CompoundTag.TAG_STRING)) {
            initWandNbt(stack);
        }
    }


}
