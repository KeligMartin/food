package use_case.recipe;

import model.recipe.Recipe;

public interface RecipeRepository {
    Recipe findById(String recipeId);
}
