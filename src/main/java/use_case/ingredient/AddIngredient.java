package use_case.ingredient;

import model.ingredient.Ingredient;
import model.ingredient.IngredientRepository;

public class AddIngredient {

    private final IngredientRepository ingredients;

    public AddIngredient(IngredientRepository ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient execute(Ingredient ingredient) throws Exception {

        if (ingredient.isExpired())
            throw new Exception("The ingredient is expired !");
        return ingredients.addIngredient(ingredient);
    }
}
