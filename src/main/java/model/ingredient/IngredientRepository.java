package model.ingredient;

public interface IngredientRepository {
    Ingredient findById(IngredientID ingredientId);
    Ingredient addIngredient(Ingredient ingredient);
    Ingredient deleteIngredient(IngredientID ingredientId);
}
