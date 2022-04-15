package model.ingredient;

import model.ingredient.Ingredient;
public interface IngredientRepository {
    Ingredient findById(String IngredientId);
    Ingredient addIngredient(Ingredient ingredient);
    void deleteIngredient(int id);
}
