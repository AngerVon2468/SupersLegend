package com.superworldsun.superslegend.items.weapons.swords;

import com.superworldsun.superslegend.items.customclass.ItemCustomSword;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BrokenGiantsKnife extends ItemCustomSword {
    public BrokenGiantsKnife(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level world, @NotNull Entity entity, int itemSlot, boolean isSelected)
    {
        if(entity instanceof Player)
        {
            Player player = (Player)entity;
            ItemStack equipped = player.getMainHandItem();
            {
                if(stack == equipped)
                {
                    if(player.hasItemInSlot(EquipmentSlot.OFFHAND))
                    {
                        player.spawnAtLocation(player.getOffhandItem());
                        player.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(@NotNull ItemStack stack, Level worldIn, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        tooltip.add(Component.literal("A Large Sword that requires two hands to wield").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
