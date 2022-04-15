package model.recipe;

import model.recipe.Recipe;

public interface RecipeRepository {
    Recipe findById(RecipeID recipeId);
    void addRecipe(Recipe recipe);
    void deleteRecipe(RecipeID id);
}
