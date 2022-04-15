package model.recipe;

import lombok.Builder;
import lombok.Getter;
import model.ingredient.Ingredient;
import model.user.DietaryRegimes;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
public class Recipe {

    private RecipeID id;

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

    @Override
    public boolean equals(Object o) {
        Recipe recipe = (Recipe) o;
        return recipe.id == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, steps, ingredients);
    }
}
