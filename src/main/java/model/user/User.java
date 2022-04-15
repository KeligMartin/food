package model.user;

import lombok.Builder;
import lombok.Getter;
import model.recipe.Recipe;
import model.user.customexception.IncompatibleRegimeException;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
public class User {
    private UserID id;
    private String username;
    private String password;
    private List<DietaryRegimes> dietaryRegimes;
    private Integer caloriesConsumed;

    public boolean isCaloriesBetweenThresholds(){
        return this.caloriesConsumed >= 100 && this.caloriesConsumed <= 1000;
    }

    public void eatRecipe(Recipe recipe) throws IncompatibleRegimeException  {
        if (!this.canEatRecipe(recipe)) {
                throw new IncompatibleRegimeException("The recipe " + recipe.getName() + " isn't compatible with the user regime.");
        }

        this.caloriesConsumed += recipe.getCalories();
    }

    public boolean canEatRecipe(Recipe recipe) {
        return recipe.isRecipeCompatibleWithRegimes(this.dietaryRegimes);
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return user.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, dietaryRegimes, caloriesConsumed);
    }
}
