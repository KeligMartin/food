package model.recipe;

import model.recipe.Recipe;

public interface RecipeRepository {
    Recipe findById(String recipeId);
    void addRecipe(Recipe recipe);
    void deleteRecipe(String id);
}
