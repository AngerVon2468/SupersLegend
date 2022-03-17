package com.superworldsun.superslegend.util.cookingpot.requirement;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.superworldsun.superslegend.util.cookingpot.CookingPotCookingRecipeInput;
import com.superworldsun.superslegend.util.cookingpot.JsonUtils;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;

import java.util.function.Predicate;

public interface IRequirement extends Predicate<CookingPotCookingRecipeInput> {
    //Code credited to Si_hen, this code is a modified version of their crockpot mod
    static IRequirement fromJson(JsonElement json) {
        if (json == null || json.isJsonNull()) {
            throw new JsonSyntaxException("Json cannot be null");
        }
        JsonObject object = JSONUtils.convertToJsonObject(json, "requirement");
        RequirementType type = JsonUtils.getAsEnum(object, "type", RequirementType.class);
        switch (type) {
            case CATEGORY_MAX:
                return RequirementCategoryMax.fromJson(object);
            case CATEGORY_MAX_EXCLUSIVE:
                return RequirementCategoryMaxExclusive.fromJson(object);
            case CATEGORY_MIN:
                return RequirementCategoryMin.fromJson(object);
            case CATEGORY_MIN_EXCLUSIVE:
                return RequirementCategoryMinExclusive.fromJson(object);
            case MUST_CONTAIN_INGREDIENT:
                return RequirementMustContainIngredient.fromJson(object);
            case MUST_CONTAIN_INGREDIENT_LESS_THAN:
                return RequirementMustContainIngredientLessThan.fromJson(object);
            case COMBINATION_AND:
                return RequirementCombinationAnd.fromJson(object);
            case COMBINATION_OR:
                return RequirementCombinationOr.fromJson(object);
            default:
                throw new IllegalArgumentException("No valid requirement type was found");
        }
    }

    JsonElement toJson();

    static IRequirement fromNetwork(PacketBuffer buffer) {
        RequirementType type = buffer.readEnum(RequirementType.class);
        switch (type) {
            case CATEGORY_MAX:
                return RequirementCategoryMax.fromNetwork(buffer);
            case CATEGORY_MAX_EXCLUSIVE:
                return RequirementCategoryMaxExclusive.fromNetwork(buffer);
            case CATEGORY_MIN:
                return RequirementCategoryMin.fromNetwork(buffer);
            case CATEGORY_MIN_EXCLUSIVE:
                return RequirementCategoryMinExclusive.fromNetwork(buffer);
            case MUST_CONTAIN_INGREDIENT:
                return RequirementMustContainIngredient.fromNetwork(buffer);
            case MUST_CONTAIN_INGREDIENT_LESS_THAN:
                return RequirementMustContainIngredientLessThan.fromNetwork(buffer);
            case COMBINATION_AND:
                return RequirementCombinationAnd.fromNetwork(buffer);
            case COMBINATION_OR:
                return RequirementCombinationOr.fromNetwork(buffer);
            default:
                throw new IllegalArgumentException("No valid requirement type was found");
        }
    }

    void toNetwork(PacketBuffer buffer);
}
