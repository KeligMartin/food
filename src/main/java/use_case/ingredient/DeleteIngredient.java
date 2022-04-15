package use_case.ingredient;

import model.ingredient.IngredientID;
import model.ingredient.IngredientRepository;

public class DeleteIngredient {

    private final IngredientRepository recipes;

    public DeleteIngredient(IngredientRepository recipes) {
        this.recipes = recipes;
    }

    public void execute(IngredientID ingredientId) {
        recipes.deleteIngredient(ingredientId);
    }
}
