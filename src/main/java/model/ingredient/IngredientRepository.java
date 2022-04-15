package model.ingredient;

public interface IngredientRepository {
    Ingredient findById(String ingredientId);
    Ingredient addIngredient(Ingredient ingredient);
    Ingredient deleteIngredient(String ingredientId);
}
