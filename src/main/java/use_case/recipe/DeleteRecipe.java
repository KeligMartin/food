package use_case.recipe;

import model.recipe.RecipeID;
import model.recipe.RecipeRepository;

public class DeleteRecipe {

    private final RecipeRepository recipes;

    public DeleteRecipe(RecipeRepository recipes) {
        this.recipes = recipes;
    }

    public void execute(RecipeID id) {
        recipes.deleteRecipe(id);
    }
}
