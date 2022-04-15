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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) && Objects.equals(name, recipe.name) && Objects.equals(steps, recipe.steps) && Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, steps, ingredients);
    }
}
