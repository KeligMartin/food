package use_case.ingredient;

import model.ingredient.IngredientRepository;

public class DeleteIngredient {

    private final IngredientRepository recipes;

    public DeleteIngredient(IngredientRepository recipes) {
        this.recipes = recipes;
    }

    public void execute(int id) {
        recipes.deleteIngredient(id);
    }
}
