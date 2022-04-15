package model.user;

import lombok.Builder;
import lombok.Getter;
import model.recipe.Recipe;
import model.user.customexception.CalorieValueNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Builder
@Getter
public class User {
    private Integer id;
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

    public void eatRecipe(Recipe recipe) {
            if (!this.canEatRecipe(recipe)) {
                    return;
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
}
