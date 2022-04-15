package use_case.recipe;

import model.recipe.Recipe;

public class FindRecipeById {

    private final RecipeRepository recipeRepository;

    public FindRecipeById(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe execute(String recipeId) {
        return recipeRepository.findById(recipeId);
    }
}
