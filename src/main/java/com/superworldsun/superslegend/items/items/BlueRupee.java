package com.superworldsun.superslegend.items.items;

import java.util.List;

import com.superworldsun.superslegend.registries.ItemInit;
import com.superworldsun.superslegend.registries.SoundInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlueRupee extends Item
{	
	public BlueRupee(Properties properties)
	{
		super(properties);
	}
	
	@Nonnull
	public ActionResult<ItemStack> use(@Nonnull World world, PlayerEntity player, @Nonnull Hand hand)
	{
		ItemStack stack = player.getItemInHand(hand);
		
		if (stack.getCount() >= 4)
		{
			
			stack.shrink(4);
			
			player.addItem(new ItemStack(ItemInit.RED_RUPEE.get()));
			
			BlockPos currentPos = player.blockPosition();
			player.level.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.RUPEE_BLUE.get(), SoundCategory.PLAYERS, 1f, 1f);
		}
		
		return new ActionResult<>(ActionResultType.PASS, player.getItemInHand(hand));		
	}
	
	public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> list, @Nonnull ITooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);
		list.add(new StringTextComponent(TextFormatting.BLUE + "5 rupee"));
	}
}