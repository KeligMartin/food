package use_case;

import model.FakeRecipes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.recipe.RecipeRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeShouldTest {

    private RecipeRepository recipeRepository;

    @BeforeEach
    public void init() {
        recipeRepository = new FakeRecipes();
    }

    @Test
    void should_find_recipe_by_id() {
        assertThat(recipeRepository.findById("001").getName()).isEqualTo("SaladeTomateOignon");
    }
}
