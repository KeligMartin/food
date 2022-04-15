package use_case.recipe;

import model.recipe.RecipeRepository;

public class DeleteRecipe {

    private final RecipeRepository recipes;

    public DeleteRecipe(RecipeRepository recipes) {
        this.recipes = recipes;
    }

    public void execute(String id) {
        recipes.deleteRecipe(id);
    }
}
