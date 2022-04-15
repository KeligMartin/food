package use_case;

import model.FakeIngredients;
import model.FakeRecipes;
import model.FakeUsers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.ingredient.IngredientRepository;
import model.recipe.RecipeRepository;
import model.user.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class UserShouldTest {
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
