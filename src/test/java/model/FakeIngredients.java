package model;

import model.ingredient.Ingredient;
import model.ingredient.IngredientRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FakeIngredients implements IngredientRepository {

    Map<String, Ingredient> ingredientMap;

    public FakeIngredients() {
        ingredientMap = new HashMap<>();

        Ingredient ingredient = Ingredient
                .builder()
                .name("Salade")
                .expirationDate(LocalDate.now())
                .build();

        Ingredient ingredient2 = Ingredient
                .builder()
                .name("Tomate")
                .expirationDate(LocalDate.now())
                .build();

        Ingredient ingredient3 = Ingredient
                .builder()
                .name("Oignons")
                .expirationDate(LocalDate.now())
                .build();

        ingredientMap.put("001", ingredient);
        ingredientMap.put("002", ingredient2);
        ingredientMap.put("003", ingredient3);
    }


    @Override
    public Ingredient findById(String IngredientId) {
        return ingredientMap.get(IngredientId);
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return null;
    }

    @Override
    public void deleteIngredient(int id) {

    }
}
