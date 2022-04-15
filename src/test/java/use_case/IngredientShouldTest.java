package use_case;

import model.FakeIngredients;
import model.ingredient.IngredientID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.ingredient.IngredientRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientShouldTest {

    private static final IngredientID INGREDIENT_ID = new IngredientID("001");

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
