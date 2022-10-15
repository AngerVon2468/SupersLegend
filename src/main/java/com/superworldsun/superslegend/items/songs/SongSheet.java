package com.superworldsun.superslegend.items.songs;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.client.config.SupersLegendConfig;
import com.superworldsun.superslegend.songs.LearnedSongsProvider;
import com.superworldsun.superslegend.songs.OcarinaSong;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = SupersLegendMain.MOD_ID)
public abstract class SongSheet extends Item
{
	private final Supplier<OcarinaSong> songSupplier;
	
	public SongSheet(Supplier<OcarinaSong> songSupplier)
	{
		super(new Item.Properties().tab(SupersLegendMain.RESOURCES).stacksTo(1));
		this.songSupplier = songSupplier;
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onPreRenderTooltip(RenderTooltipEvent.PostText event)
	{
		if (event.getStack().getItem() instanceof SongSheet)
		{
			SongSheet songSheet = (SongSheet) event.getStack().getItem();
			String notes = songSheet.getSong().getPattern();
			ResourceLocation texture = new ResourceLocation(SupersLegendMain.MOD_ID, "textures/gui/ocarina.png");
			Minecraft.getInstance().getTextureManager().bind(texture);
			int notesIconsWidth = notes.length() * 11 + (notes.length() - 1) * 2;
			int x = event.getX() + (event.getWidth() - notesIconsWidth) / 2;
			int y = event.getY() + event.getHeight() - 16;
			
			for (int i = event.getLines().size() - 1; i > 0; i--)
			{
				if (event.getLines().get(i).getString().isEmpty())
				{
					break;
				}
				
				y -= 10;
			}
			
			for (int i = 0; i < notes.length(); i++)
			{
				int noteX = x + 13 * i;
				int noteU = 0;
				
				switch (notes.charAt(i))
				{
					case 'a':
						noteU = 44;
						break;
					case 'd':
						noteU = 33;
						break;
					case 'r':
						noteU = 22;
						break;
					case 'l':
						noteU = 11;
						break;
				}
				
				AbstractGui.blit(event.getMatrixStack(), noteX, y, 0, noteU, 30, 11, 11, 256, 256);
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);
		addSongDescription(list);
		list.add(new StringTextComponent(""));
		list.add(new StringTextComponent(""));
		list.add(new StringTextComponent(TextFormatting.GOLD + "Right click to Learn Song"));
	}
	
	// TODO add config to have this item consumed on use
	// TODO add a sound when item is used
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
	{
		Set<OcarinaSong> learnedSongs = LearnedSongsProvider.get(playerEntity).getLearnedSongs();
		
		if (!world.isClientSide)
		{
			if (!learnedSongs.contains(songSupplier.get()))
			{
				if (SupersLegendConfig.getInstance().songSheetConsumed())
					playerEntity.getItemInHand(hand).shrink(1);
				
				learnedSongs.add(songSupplier.get());
				LearnedSongsProvider.sync((ServerPlayerEntity) playerEntity);
				playerEntity.sendMessage(new TranslationTextComponent("item.superslegend.song_sheet.learned", songSupplier.get().getLocalizedName()), UUID.randomUUID());
				return ActionResult.success(playerEntity.getItemInHand(hand));
			}
			else
			{
				playerEntity.sendMessage(new TranslationTextComponent("item.superslegend.song_sheet.already_know"), UUID.randomUUID());
			}
		}
		
		return ActionResult.fail(playerEntity.getItemInHand(hand));
	}
	
	public OcarinaSong getSong()
	{
		return songSupplier.get();
	}
	
	protected abstract void addSongDescription(List<ITextComponent> list);
}
