package model.recipe;

import lombok.Builder;
import lombok.Getter;
import model.ingredient.Ingredient;
import model.user.DietaryRegimes;

import java.util.List;

@Builder
@Getter
public class Recipe {

    private String id;

    private String name;

    private List<String> steps;

    private List<Ingredient> ingredients;

    public void validate(){

    }

    public boolean isRecipeCompatibleWithRegimes(List<DietaryRegimes> regimes) {
        return ingredients.stream().allMatch(ingredient -> ingredient.isCompatibleWithRegimeList(regimes));
    }

    public Integer getCalories() {
        return this.ingredients.stream()
                .map(Ingredient::getCalorie)
                .reduce(0, Integer::sum);
    }
}
