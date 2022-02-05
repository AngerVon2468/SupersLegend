package com.superworldsun.superslegend.util.cookingpot;

import com.google.gson.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.EnumUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class JsonUtils {
    //Code credited to Si_hen, this code is a modified version of their crockpot mod
    public static final Gson GSON = new GsonBuilder().create();

    public static boolean isStringValue(JsonElement json) {
        return json.isJsonPrimitive() && json.getAsJsonPrimitive().isString();
    }

    @Nullable
    public static Item convertToItem(JsonElement json, String memberName) {
        if (JsonUtils.isStringValue(json)) {
            String s = json.getAsString();
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));
            return item == Items.AIR ? null : item;
        } else {
            throw new JsonSyntaxException("Expected " + memberName + " to be an item, was " + JSONUtils.getType(json));
        }
    }

    @Nullable
    public static Item getAsItem(JsonObject json, String memberName) {
        if (json.has(memberName)) {
            return convertToItem(json.get(memberName), memberName);
        } else {
            throw new JsonSyntaxException("Missing " + memberName + ", expected to find an item");
        }
    }

    public static ItemStack convertToItemStack(JsonElement json, String memberName) {
        if (json.isJsonObject()) {
            JsonObject object = json.getAsJsonObject();
            return ShapedRecipe.itemFromJson(object);
        } else if (JsonUtils.isStringValue(json)) {
            Item item = JSONUtils.convertToItem(json, memberName);
            return item.getDefaultInstance();
        } else {
            throw new JsonSyntaxException("Expected " + memberName + " to be an item stack, was " + JSONUtils.getType(json));
        }
    }

    public static ItemStack getAsItemStack(JsonObject json, String memberName) {
        if (json.has(memberName)) {
            return convertToItemStack(json.get(memberName), memberName);
        } else {
            throw new JsonSyntaxException("Missing " + memberName + ", expected to find an item stack");
        }
    }

    @Nonnull
    public static Ingredient getAsIngredient(JsonObject json, String memberName) {
        return getAsIngredient(json, memberName, false);
    }

    public static Ingredient getAsIngredient(JsonObject json, String memberName, boolean skip) {
        if (json.has(memberName)) {
            if (skip) {
                if (json.get(memberName).isJsonArray()) {
                    JsonArray array = json.getAsJsonArray(memberName);
                    JsonArray result = new JsonArray();
                    for (JsonElement e : array) {
                        JsonObject obj = JSONUtils.convertToJsonObject(e, "item");
                        if (obj.has("item") && obj.has("tag")) {
                            throw new JsonParseException("An ingredient entry is either a tag or an item, not both");
                        } else if (obj.has("item")) {
                            ResourceLocation name = new ResourceLocation(JSONUtils.getAsString(obj, "item"));
                            Item item = ForgeRegistries.ITEMS.getValue(name);
                            if (item == null || item == Items.AIR) {
                                continue;
                            }
                        } else if (obj.has("tag")) {
                            ResourceLocation name = new ResourceLocation(JSONUtils.getAsString(obj, "tag"));
                            ITag<Item> tag = TagCollectionManager.getInstance().getItems().getTag(name);
                            if (tag == null) {
                                continue;
                            }
                        } else {
                            throw new JsonParseException("An ingredient entry needs either a tag or an item");
                        }
                        result.add(e);
                    }
                    return Ingredient.fromJson(result);
                } else {
                    return Ingredient.fromJson(json.get(memberName));
                }
            } else {
                return Ingredient.fromJson(json.get(memberName));
            }
        } else {
            throw new JsonSyntaxException("Missing " + memberName + ", expected to find an ingredient");
        }
    }

    public static <E extends Enum<E>> E convertToEnum(JsonElement json, String memberName, Class<E> enumClass) {
        if (JsonUtils.isStringValue(json)) {
            String enumName = JSONUtils.convertToString(json, memberName).toUpperCase();
            if (!EnumUtils.isValidEnum(enumClass, enumName)) {
                throw new JsonSyntaxException("Expected " + memberName + " to be an enum of " + enumClass.getName() + ", was unknown name: '" + enumName + "'");
            }
            return EnumUtils.getEnum(enumClass, enumName);
        } else {
            throw new JsonSyntaxException("Expected " + memberName + " to be an enum of " + enumClass.getName() + ", was" + JSONUtils.getType(json));
        }
    }

    public static <E extends Enum<E>> E getAsEnum(JsonObject json, String memberName, Class<E> enumClass) {
        if (json.has(memberName)) {
            return convertToEnum(json.get(memberName), memberName, enumClass);
        } else {
            throw new JsonSyntaxException("Missing " + memberName + ", expected to find an enum");
        }
    }
}
