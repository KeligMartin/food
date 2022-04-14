package use_case.recipe;

import model.recipe.Recipes;

public class DeleteRecipe {

    private final Recipes recipes;

    public DeleteRecipe(Recipes recipes) {
        this.recipes = recipes;
    }

    public void execute(int id) {
        recipes.deleteRecipe(id);
    }
}
