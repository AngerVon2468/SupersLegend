package com.superworldsun.superslegend.util.cookingpot.requirement;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.superworldsun.superslegend.util.cookingpot.FoodCategory;
import com.superworldsun.superslegend.util.cookingpot.CookingPotCookingRecipeInput;
import com.superworldsun.superslegend.util.cookingpot.JsonUtils;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;

public class RequirementCategoryMin implements IRequirement {
    //Code credited to Si_hen, this code is a modified version of their crockpot mod
    private final FoodCategory category;
    private final float min;

    public RequirementCategoryMin(FoodCategory category, float min) {
        this.category = category;
        this.min = min;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public float getMin() {
        return min;
    }

    @Override
    public boolean test(CookingPotCookingRecipeInput recipeInput) {
        return recipeInput.mergedFoodValues.get(category) >= min;
    }

    public static RequirementCategoryMin fromJson(JsonObject object) {
        return new RequirementCategoryMin(JsonUtils.getAsEnum(object, "category", FoodCategory.class), JSONUtils.getAsFloat(object, "min"));
    }

    @Override
    public JsonElement toJson() {
        JsonObject obj = new JsonObject();
        obj.addProperty("type", RequirementType.CATEGORY_MIN.name());
        obj.addProperty("category", category.name());
        obj.addProperty("min", min);
        return obj;
    }

    public static RequirementCategoryMin fromNetwork(PacketBuffer buffer) {
        return new RequirementCategoryMin(buffer.readEnum(FoodCategory.class), buffer.readFloat());
    }

    @Override
    public void toNetwork(PacketBuffer buffer) {
        buffer.writeEnum(RequirementType.CATEGORY_MIN);
        buffer.writeEnum(category);
        buffer.writeFloat(min);
    }
}
