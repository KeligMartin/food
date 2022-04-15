package use_case;

import model.FakeIngredients;
import model.FakeRecipes;
import model.FakeUsers;
import org.junit.jupiter.api.BeforeEach;
import use_case.ingredient.IngredientRepository;
import use_case.recipe.RecipeRepository;
import use_case.user.UserRepository;

public class UserShould {
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        ingredientRepository = new FakeIngredients();
        recipeRepository = new FakeRecipes();
        userRepository = new FakeUsers();
    }

}
