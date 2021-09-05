package com.superworldsun.superslegend.items.masks;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.client.model.ModelHerosCharm;
import com.superworldsun.superslegend.items.custom.NonEnchantArmor;
import com.superworldsun.superslegend.registries.ArmourInit;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaskHerosCharm extends NonEnchantArmor

{
    private static final Map<EquipmentSlotType, BipedModel<?>> MODELS_CACHE = new HashMap<>();

        public MaskHerosCharm(Properties properties)
        {
            super(ArmourInit.HEROS_CHARM, EquipmentSlotType.HEAD, properties);
        }

        /*@Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
        {
            return SupersLegendMain.MOD_ID + ":textures/armor/giantsmask_layer_1.png";
        }*/

    /*@SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
        return (A) new ModelHerosCharm(0);
    }*/

    @SuppressWarnings("unchecked")
    @Override
    public <M extends BipedModel<?>> M getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, M _default)
    {
        if (!MODELS_CACHE.containsKey(armorSlot))
        {
            MODELS_CACHE.put(armorSlot, new ModelHerosCharm(armorSlot));
        }

        return (M) MODELS_CACHE.get(armorSlot);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
    {
        return SupersLegendMain.MOD_ID + ":textures/models/armor/heroscharm.png";
    }




        @Override
        public @Nonnull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers (@Nonnull EquipmentSlotType
        equipmentSlot){
        return HashMultimap.create();
    }


        @Override
        public void appendHoverText (ItemStack stack, World world, List < ITextComponent > list, ITooltipFlag flag)
        {
            super.appendHoverText(stack, world, list, flag);
            list.add(new StringTextComponent(TextFormatting.WHITE + "Allows you to find ones weakness"));
        }
    }




