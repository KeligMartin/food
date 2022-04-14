package use_case;

import model.Recipe;
import model.Recipes;

public class AddRecipe {

    private final Recipes recipes;

    public AddRecipe(Recipes recipes) {
        this.recipes = recipes;
    }

    public void execute(Recipe recipe) {
        recipes.addRecipe(recipe);
    }
}
