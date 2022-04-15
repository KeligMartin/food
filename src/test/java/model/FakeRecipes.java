package model;

import model.ingredient.Ingredient;
import model.recipe.Recipe;
import model.recipe.RecipeID;
import model.recipe.RecipeRepository;
import model.user.DietaryRegimes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeRecipes implements RecipeRepository {

    Map<String, Recipe> recipeMap;

    public FakeRecipes() {
        recipeMap = new HashMap<>();

        List<Ingredient> ingredientList = new ArrayList<>();
        List<Ingredient> ingredient2List = new ArrayList<>();
        List<String> steps = new ArrayList<>();

        List<DietaryRegimes> allRegime = new ArrayList<>();
        allRegime.add(DietaryRegimes.ALL);

        List<DietaryRegimes> regularRegime = new ArrayList<>();
        regularRegime.add(DietaryRegimes.REGULAR);

        Ingredient salade = Ingredient
                .builder()
                .name("Salade")
                .calorie(15)
                .compatibleRegimeList(allRegime)
                .expirationDate(LocalDate.now())
                .build();

        Ingredient tomate = Ingredient
                .builder()
                .name("Tomate")
                .calorie(20)
                .compatibleRegimeList(allRegime)
                .expirationDate(LocalDate.now())
                .build();

        Ingredient oignons = Ingredient
                .builder()
                .name("Oignons")
                .calorie(40)
                .compatibleRegimeList(allRegime)
                .expirationDate(LocalDate.now())
                .build();


        Ingredient steak = Ingredient
                .builder()
                .name("Steak")
                .calorie(271)
                .compatibleRegimeList(regularRegime)
                .expirationDate(LocalDate.now())
                .build();

        ingredientList.add(salade);
        ingredientList.add(tomate);
        ingredientList.add(oignons);

        ingredient2List.add(salade);
        ingredient2List.add(tomate);
        ingredient2List.add(oignons);
        ingredient2List.add(steak);

        steps.add(salade.getName());
        steps.add(tomate.getName());
        steps.add(oignons.getName());

        Recipe recipe = Recipe
                .builder()
                .name("SaladeTomateOignon")
                .steps(steps)
                .ingredients(ingredientList)
                .build();

        Recipe recipe2 = Recipe
                .builder()
                .name("SaladeTomateOignonSteak")
                .steps(steps)
                .ingredients(ingredient2List)
                .build();

        recipeMap.put("001", recipe);
        recipeMap.put("002", recipe2);

    }

    @Override
    public Recipe findById(RecipeID recipeId) {
        return recipeMap.get(recipeId);
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public void deleteRecipe(RecipeID id) {

    }
}