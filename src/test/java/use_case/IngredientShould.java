package use_case;

import model.FakeIngredients;
import model.ingredient.Ingredients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.ingredient.IngredientRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientShould {

    private static final String INGREDIENT_ID = "001";

    private IngredientRepository fakeIngredients;

    @BeforeEach
    public void init() {
        this.fakeIngredients = new FakeIngredients();
    }

    @Test
    void should_find_ingredient_by_id() {
        assertThat(fakeIngredients.findById(INGREDIENT_ID).getName()).isEqualTo("Salade");
    }
}
