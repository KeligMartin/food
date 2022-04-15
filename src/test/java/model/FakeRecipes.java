package model;

import model.ingredient.Ingredient;
import model.recipe.Recipe;
import model.recipe.RecipeRepository;
import model.user.DietaryRegimes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeRecipes implements RecipeRepository {

    Map<String, Recipe> recipeMap;
    FakeIngredients fakeIngredients;

    public FakeRecipes() {
<<<<<<< HEAD
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
=======
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
>>>>>>> c755e84670ec290955d59a062cddeca183cedae6

        Recipe saladeTomateOignon = Recipe
                .builder()
<<<<<<< HEAD
                .name("SaladeTomateOignon")
                .steps(saladeTomateOignonSteps)
                .ingredients(saladeTomateOignonIngredientList)
=======
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
>>>>>>> c755e84670ec290955d59a062cddeca183cedae6
                .build();

        List<Ingredient> steakFriteIngredientList = new ArrayList<>();
        List<String> steakFriteSteps = new ArrayList<>();

        Ingredient viande = fakeIngredients.findById("004");

<<<<<<< HEAD
        steakFriteIngredientList.add(viande);
        steakFriteIngredientList.add(tomate);
=======
        ingredient2List.add(salade);
        ingredient2List.add(tomate);
        ingredient2List.add(oignons);
        ingredient2List.add(steak);

        steps.add(salade.getName());
        steps.add(tomate.getName());
        steps.add(oignons.getName());
>>>>>>> c755e84670ec290955d59a062cddeca183cedae6

        steakFriteSteps.add(viande.getName());
        steakFriteSteps.add(tomate.getName());

        Recipe steakFrite = Recipe
                .builder()
                .name("SteakFrite")
                .steps(steakFriteSteps)
                .ingredients(steakFriteIngredientList)
                .build();

<<<<<<< HEAD
                recipeMap.put("001", saladeTomateOignon);
                recipeMap.put("002", steakFrite);
=======
        Recipe recipe2 = Recipe
                .builder()
                .name("SaladeTomateOignonSteak")
                .steps(steps)
                .ingredients(ingredient2List)
                .build();

        recipeMap.put("001", recipe);
        recipeMap.put("002", recipe2);
>>>>>>> c755e84670ec290955d59a062cddeca183cedae6

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
