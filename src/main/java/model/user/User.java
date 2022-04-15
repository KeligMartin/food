package model.user;

import lombok.Builder;
import lombok.Getter;
import model.recipe.Recipe;
import model.user.customexception.CalorieValueNotFoundException;
import model.user.customexception.IncompatibleRegimeException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Builder
@Getter
public class User {
    private String id;
    private String username;
    private String password;
    private List<DietaryRegimes> dietaryRegimes;
    private Map<LocalDate, Integer> caloriesConsumedByDate;

    public Optional<Integer> getCaloriesByDate(LocalDate date) {
        return Optional.ofNullable(this.caloriesConsumedByDate.get(date));
    }

    public boolean isCaloriesOfTheDayValid(LocalDate date) throws CalorieValueNotFoundException {
        Optional<Integer> calories = this.getCaloriesByDate(date);
        if (calories.isEmpty()){
            throw new CalorieValueNotFoundException("This user has no calories for this day");
        }
        return isCaloriesBetweenThresholds(calories.get());
    }

    public boolean isCaloriesBetweenThresholds(Integer caloriesValue){
        return caloriesValue >= 100 && caloriesValue <= 1000;
    }

    public void eatRecipe(Recipe recipe) throws IncompatibleRegimeException  {
            if (!this.canEatRecipe(recipe)) {
                    throw new IncompatibleRegimeException("The recipe " + recipe.getName() + " isn't compatible with the user regime.");
            }

            Optional<Integer> calorieOfTheDay = getCaloriesByDate(LocalDate.now());

            if (calorieOfTheDay.isEmpty()) {
                    this.caloriesConsumedByDate.put(LocalDate.now(), recipe.getCalories());
                    return;
            }

            if (isCaloriesBetweenThresholds(calorieOfTheDay.get() + recipe.getCalories()))
                    this.caloriesConsumedByDate.put(LocalDate.now(), calorieOfTheDay.get() + recipe.getCalories());
    }

    public boolean canEatRecipe(Recipe recipe) {
        return recipe.isRecipeCompatibleWithRegimes(this.dietaryRegimes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(dietaryRegimes, user.dietaryRegimes) && Objects.equals(caloriesConsumedByDate, user.caloriesConsumedByDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, dietaryRegimes, caloriesConsumedByDate);
    }
}
