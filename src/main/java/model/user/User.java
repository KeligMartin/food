package model.user;

import lombok.Builder;
import lombok.Getter;
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

        public boolean isCaloriesOfTheDayIsValide(LocalDate date) throws CalorieValueNotFoundException {
                Optional<Integer> calories = this.getCaloriesByDate(date);
                if (calories.isEmpty()){
                        throw new CalorieValueNotFoundException("This user has no calories for this day");
                }
                return isCaloriesBetweenThresholds(calories.get());
        }

        public boolean isCaloriesBetweenThresholds(Integer caloriesValue){
                return caloriesValue >= 100 && caloriesValue <= 1000;
        }
}
