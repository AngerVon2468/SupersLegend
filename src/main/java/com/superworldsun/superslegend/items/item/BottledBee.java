package com.superworldsun.superslegend.items.item;

import com.superworldsun.superslegend.registries.SoundInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BottledBee extends Item
{
    public BottledBee(Properties properties)
    {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if(!level.isClientSide && !player.isCreative())
        {
            player.playSound(SoundInit.BOTTLE_POP.get(), 1f, 1f);

            if (!player.level().isClientSide)
            {
                Bee entity = EntityType.BEE.create(player.level());
                entity.moveTo(player.getX(), player.getY(), player.getZ(), player.yRotO, 0.0F);
                player.level().addFreshEntity(entity);
                player.getCooldowns().addCooldown(this, 6);
            }
            stack.shrink(1);
            player.addItem(new ItemStack(Items.GLASS_BOTTLE));
        }

        if(!level.isClientSide && player.isCreative())
        {
            player.playSound(SoundInit.BOTTLE_POP.get(), 1f, 1f);

            if (!player.level().isClientSide)
            {
                Bee entity = EntityType.BEE.create(player.level());
                //entity.getAngerTarget()
                entity.moveTo(player.getX(), player.getY(), player.getZ(), player.yRotO, 0.0F);
                player.level().addFreshEntity(entity);
                player.getCooldowns().addCooldown(this, 6);
            }
        }
        return new InteractionResultHolder<>(InteractionResult.PASS, player.getItemInHand(hand));
    }
}