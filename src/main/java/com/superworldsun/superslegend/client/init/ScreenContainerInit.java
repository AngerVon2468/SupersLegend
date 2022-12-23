package com.superworldsun.superslegend.client.init;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.client.screen.*;
import com.superworldsun.superslegend.registries.ContainerInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SupersLegendMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ScreenContainerInit
{
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event)
	{
		ScreenManager.register(ContainerInit.BAG.get(), BagScreen::new);
		ScreenManager.register(ContainerInit.RING_BOX.get(), RingBoxScreen::new);
		ScreenManager.register(ContainerInit.RING_BOX_BIG.get(), BigRingBoxScreen::new);
		ScreenManager.register(ContainerInit.RING_BOX_BIGGEST.get(), BiggestRingBoxScreen::new);
		ScreenManager.register(ContainerInit.LETTER.get(), LetterScreen::new);
		ScreenManager.register(ContainerInit.SMALL_QUIVER.get(), SmallQuiverScreen::new);
		ScreenManager.register(ContainerInit.MEDIUM_QUIVER.get(), MediumQuiverScreen::new);
		ScreenManager.register(ContainerInit.BIG_QUIVER.get(), BigQuiverScreen::new);
		ScreenManager.register(ContainerInit.SMALL_BOMB_BAG.get(), SmallBombBagScreen::new);
		// ScreenManager.register(ContainerInit.MEDIUM_BOMB_BAG.get(), MediumQuiverScreen::new);
		// ScreenManager.register(ContainerInit.BIG_BOMB_BAG.get(), BigQuiverScreen::new);
		ScreenManager.register(ContainerInit.POSTBOX.get(), PostboxScreen::new);
		ScreenManager.register(ContainerInit.SELECT_CONTAINER.get(), SelectScreen::new);
		ScreenManager.register(ContainerInit.COOKING_POT.get(), CookingPotScreen::new);
	}
}