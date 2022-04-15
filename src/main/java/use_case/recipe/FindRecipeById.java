package use_case.recipe;

import model.recipe.Recipe;
import model.recipe.RecipeID;
import model.recipe.RecipeRepository;

public class FindRecipeById {

    private final RecipeRepository recipeRepository;

    public FindRecipeById(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe execute(RecipeID recipeId) {
        return recipeRepository.findById(recipeId);
    }
}
