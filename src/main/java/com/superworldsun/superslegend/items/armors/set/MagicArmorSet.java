package com.superworldsun.superslegend.items.armors.set;

import com.superworldsun.superslegend.registries.ItemInit;
import net.minecraft.world.item.crafting.Ingredient;

public class MagicArmorSet extends ArmorSet {
	public MagicArmorSet() {
		super("magic", 1, 1, 1, 1, () -> Ingredient.of(ItemInit.KOKIRI_TUNIC::get));
	}
}
