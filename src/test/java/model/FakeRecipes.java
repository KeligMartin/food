package model;

import model.ingredient.Ingredient;
import model.recipe.Recipe;
import model.recipe.RecipeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeRecipes implements RecipeRepository {

    Map<String, Recipe> recipeMap;
    FakeIngredients fakeIngredients;

    public FakeRecipes() {
        FakeIngredients fakeIngredients = new FakeIngredients();

        recipeMap = new HashMap<>();
        List<Ingredient> saladeTomateOignonIngredientList = new ArrayList<>();
        List<String> saladeTomateOignonSteps = new ArrayList<>();

        Ingredient salade = fakeIngredients.findById("001");
        Ingredient tomate = fakeIngredients.findById("002");
        Ingredient oignons = fakeIngredients.findById("003");

        saladeTomateOignonIngredientList.add(salade);
        saladeTomateOignonIngredientList.add(tomate);
        saladeTomateOignonIngredientList.add(oignons);

        saladeTomateOignonSteps.add(salade.getName());
        saladeTomateOignonSteps.add(tomate.getName());
        saladeTomateOignonSteps.add(oignons.getName());

        Recipe saladeTomateOignon = Recipe
                .builder()
                .name("SaladeTomateOignon")
                .steps(saladeTomateOignonSteps)
                .ingredients(saladeTomateOignonIngredientList)
                .build();

        List<Ingredient> steakFriteIngredientList = new ArrayList<>();
        List<String> steakFriteSteps = new ArrayList<>();

        Ingredient viande = fakeIngredients.findById("004");

        steakFriteIngredientList.add(viande);
        steakFriteIngredientList.add(tomate);

        steakFriteSteps.add(viande.getName());
        steakFriteSteps.add(tomate.getName());

        Recipe steakFrite = Recipe
                .builder()
                .name("SteakFrite")
                .steps(steakFriteSteps)
                .ingredients(steakFriteIngredientList)
                .build();

                recipeMap.put("001", saladeTomateOignon);
                recipeMap.put("002", steakFrite);

    }

    @Override
    public Recipe findById(String recipeId) {
        return recipeMap.get(recipeId);
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public void deleteRecipe(String id) {

    }
}
