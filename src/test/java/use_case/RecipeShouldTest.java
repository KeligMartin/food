package use_case;

import model.FakeRecipes;
import model.recipe.Recipe;
import model.recipe.RecipeID;
import model.user.DietaryRegimes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.recipe.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeShouldTest {

    private RecipeRepository recipeRepository;

    @BeforeEach
    public void init() {
        recipeRepository = new FakeRecipes();
    }

    @Test
    void should_find_recipe_by_id() {
        assertThat(recipeRepository.findById(new RecipeID("001")).getName()).isEqualTo("SaladeTomateOignon");
    }

    @Test
    void recipe_should_be_allowed_for_regular_regime() {
        Recipe recipe = recipeRepository.findById(new RecipeID("001"));

        List<DietaryRegimes> regime = new ArrayList<>();
        regime.add(DietaryRegimes.REGULAR);

        assertThat(recipe.isRecipeCompatibleWithRegimes(regime)).isTrue();
    }

    @Test
    void recipe_should_not_be_allowed_for_vegan_regime() {
        Recipe recipe = recipeRepository.findById(new RecipeID("002"));
        List<DietaryRegimes> regime = new ArrayList<>();
        regime.add(DietaryRegimes.VEGAN);

        assertThat(recipe.isRecipeCompatibleWithRegimes(regime)).isFalse();
    }

    @Test
    void should_sum_the_total_of_calorie() {
        Recipe recipe = recipeRepository.findById(new RecipeID("001"));

        assertThat(recipe.getCalories()).isEqualTo(75);
    }
}
