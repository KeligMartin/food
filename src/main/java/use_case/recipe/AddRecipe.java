package use_case.recipe;

import model.recipe.Recipe;
import model.recipe.RecipeRepository;

public class AddRecipe {

    private final RecipeRepository recipes;

    public AddRecipe(RecipeRepository recipes) {
        this.recipes = recipes;
    }

    public void execute(Recipe recipe) {
        recipes.addRecipe(recipe);
    }
}
