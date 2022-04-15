package model;

import model.ingredient.Ingredient;
import model.recipe.Recipe;
import use_case.recipe.RecipeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeRecipes implements RecipeRepository {

    Map<String, Recipe> recipeMap;

    FakeRecipes() {

        recipeMap = new HashMap<>();
        List<Ingredient> ingredientList = new ArrayList<>();
        List<String> steps = new ArrayList<>();

        Ingredient salade = Ingredient
                .builder()
                .name("Salade")
                .expirationDate(LocalDate.now())
                .build();

        Ingredient tomate = Ingredient
                .builder()
                .name("Tomate")
                .expirationDate(LocalDate.now())
                .build();

        Ingredient oignons = Ingredient
                .builder()
                .name("Oignons")
                .expirationDate(LocalDate.now())
                .build();

        ingredientList.add(salade);
        ingredientList.add(tomate);
        ingredientList.add(oignons);

        steps.add(salade.getName());
        steps.add(tomate.getName());
        steps.add(oignons.getName());

        Recipe recipe = Recipe
                .builder()
                .name("SaladeTomateOignon")
                .steps(steps)
                .ingredients(ingredientList)
                .build();

        recipeMap.put("001", recipe);

    }

    @Override
    public Recipe findById(String recipeId) {
        return recipeMap.get(recipeId);
    }
}
