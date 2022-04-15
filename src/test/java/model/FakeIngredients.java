package model;

import model.ingredient.Ingredient;
import model.ingredient.IngredientRepository;
import model.user.DietaryRegimes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeIngredients implements IngredientRepository {

    Map<String, Ingredient> ingredientMap;

    public FakeIngredients() {
        ingredientMap = new HashMap<>();

        Ingredient ingredient = Ingredient
                .builder()
                .name("Salade")
                .calorie(15)
                .expirationDate(LocalDate.now())
                .compatibleRegimeList(new ArrayList<>(List.of(DietaryRegimes.VEGAN)))
                .build();

        Ingredient ingredient2 = Ingredient
                .builder()
                .name("Tomate")
                .calorie(20)
                .expirationDate(LocalDate.now())
                .compatibleRegimeList(new ArrayList<>(List.of(DietaryRegimes.VEGAN)))
                .build();

        Ingredient ingredient3 = Ingredient
                .builder()
                .name("Oignons")
                .calorie(40)
                .expirationDate(LocalDate.now())
                .compatibleRegimeList(new ArrayList<>(List.of(DietaryRegimes.VEGAN)))
                .build();

        Ingredient ingredient4 = Ingredient
                .builder()
                .name("Viande")
                .calorie(300)
                .expirationDate(LocalDate.now())
                .compatibleRegimeList(new ArrayList<>())
                .build();

        ingredientMap.put("001", ingredient);
        ingredientMap.put("002", ingredient2);
        ingredientMap.put("003", ingredient3);
        ingredientMap.put("004", ingredient4);
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
    public Ingredient deleteIngredient(String ingredientId) {
        return ingredientMap.remove(ingredientId);
    }
}
