package use_case.ingredient;

import model.ingredient.Ingredient;
public interface IngredientRepository {
    Ingredient findById(String IngredientId);
}
