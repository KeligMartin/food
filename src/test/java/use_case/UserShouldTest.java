package use_case;

import model.FakeIngredients;
import model.FakeRecipes;
import model.FakeUsers;
import model.recipe.RecipeID;
import model.user.UserID;
import model.recipe.Recipe;
import model.user.User;
import model.user.customexception.IncompatibleRegimeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.ingredient.IngredientRepository;
import model.recipe.RecipeRepository;
import model.user.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserShouldTest {
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private UserRepository userRepository;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @BeforeEach
    public void init() {
        ingredientRepository = new FakeIngredients();
        recipeRepository = new FakeRecipes();
        userRepository = new FakeUsers();
    }

    @Test
    void should_find_user_by_id() {
        assertThat(userRepository.findById(new UserID("001")).getUsername()).isEqualTo("user1");
    }

    @Test
    void should_user_eat_recipe_with_incompatible_regime_throw_IncompatibleRegimeException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            userRepository.findById(new UserID("001")).eatRecipe(recipeRepository.findById(new RecipeID("001")));
        });
    }

    @Test
    void should_user_eat_recipe_without_calories_for_the_day_create_entry_for_the_day() throws IncompatibleRegimeException {
        User user = userRepository.findById(new UserID("002"));
        Recipe recipe = recipeRepository.findById(new RecipeID("001"));
        Integer caloriesOfUser = user.getCaloriesConsumed();
        Integer caloriesOfRecipe = recipe.getCalories();

        user.eatRecipe(recipe);

        Integer caloriesAfterEat = user.getCaloriesConsumed();
        assertEquals(caloriesAfterEat, caloriesOfRecipe + caloriesOfUser);
    }

}
