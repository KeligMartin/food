package use_case.ingredient;

import model.ingredient.Ingredients;

public class DeleteIngredient {

    private final Ingredients recipes;

    public DeleteIngredient(Ingredients recipes) {
        this.recipes = recipes;
    }

    public void execute(int id) {
        recipes.deleteIngredient(id);
    }
}
