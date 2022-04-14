package model.recipe;

import lombok.Builder;
import lombok.Getter;
import model.ingredient.Ingredient;
import model.user.DietaryRegimes;

import java.util.List;

@Builder
@Getter
public class Recipe {

    private int id;

    private String name;

    private List<String> steps;

    private List<Ingredient> ingredients;

    public void validate(){

    }

    public boolean isCompatibleWithRegimes(List<DietaryRegimes> regimes) {
        boolean isCompatible = true;
        for (Ingredient ingredient: this.ingredients) {
            for (DietaryRegimes regime: regimes) {
                if (!ingredient.getCompatibleRegimes().contains(regime)){
                    isCompatible = false;
                    break;
                }
            }
            if (!isCompatible)
                break;
        }
        return isCompatible;
    }
}
