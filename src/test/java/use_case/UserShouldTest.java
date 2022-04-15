package use_case;

import model.FakeIngredients;
import model.FakeRecipes;
import model.FakeUsers;
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
        assertThat(userRepository.findById("001").getUsername()).isEqualTo("user1");
    }

    @Test
    void should_user_eat_recipe_with_incompatible_regime_throw_IncompatibleRegimeException() {
        assertThrows(IncompatibleRegimeException.class, () -> {
            userRepository.findById("003").eatRecipe(recipeRepository.findById("002"));
        });
    }

    @Test
    void should_user_eat_recipe_without_calories_for_the_day_create_entry_for_the_day() throws IncompatibleRegimeException {
        User user = userRepository.findById("002");
        Recipe recipe = recipeRepository.findById("001");
        Integer caloriesOfUser = user.getCaloriesConsumed();
        Integer caloriesOfRecipe = recipe.getCalories();

        user.eatRecipe(recipe);

        Integer caloriesAfterEat = user.getCaloriesConsumed();
        assertEquals(caloriesAfterEat, caloriesOfRecipe + caloriesOfUser);
    }

}
