package use_case;

import model.FakeIngredients;
import model.FakeRecipes;
import model.FakeUsers;
import model.user.DietaryRegimes;
import model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.ingredient.IngredientRepository;
import use_case.recipe.RecipeRepository;
import use_case.user.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void should_find_user_by_id() {
        assertThat(userRepository.findById("001").getUsername()).isEqualTo("user1");
    }

}
