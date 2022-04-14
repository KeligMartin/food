package use_case.recipe;

import model.recipe.Recipe;
import model.recipe.Recipes;

public class AddRecipe {

    private final Recipes recipes;

    public AddRecipe(Recipes recipes) {
        this.recipes = recipes;
    }

    public void execute(Recipe recipe) {
        recipes.addRecipe(recipe);
    }
}
