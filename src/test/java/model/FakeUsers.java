package model;

import model.recipe.RecipeID;
import model.user.DietaryRegimes;
import model.user.User;
import model.user.UserID;
import model.user.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeUsers implements UserRepository {
    Map<String, User> userMap;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public FakeUsers() {
        userMap = new HashMap<>();
        User user1 = User.builder()
                .username("user1")
                .password("password")
                .dietaryRegimes(new ArrayList<>(List.of(DietaryRegimes.VEGAN, DietaryRegimes.GLUTEN_INTOLERANT)))
                .caloriesConsumedByDate(Map.of(
                        LocalDate.parse("14/08/2016", dateTimeFormatter),200,
                        LocalDate.parse("15/08/2016", dateTimeFormatter),250)
                )
                .build();
        User user2 = User.builder()
                .username("user")
                .password("password")
                .dietaryRegimes(new ArrayList<>(List.of(DietaryRegimes.GLUTEN_INTOLERANT)))
                .caloriesConsumedByDate(Map.of(
                        LocalDate.parse("14/08/2016", dateTimeFormatter),600,
                        LocalDate.parse("15/08/2016", dateTimeFormatter),400)
                )
                .build();
        User user3 = User.builder()
                .username("user")
                .password("password")
                .dietaryRegimes(new ArrayList<>(List.of(DietaryRegimes.VEGAN)))
                .caloriesConsumedByDate(Map.of(
                        LocalDate.parse("14/08/2016", dateTimeFormatter),500,
                        LocalDate.parse("15/08/2016", dateTimeFormatter),300)
                )
                .build();

        userMap.put("001", user1);
        userMap.put("002", user2);
        userMap.put("003", user3);
    }

    @Override
    public User findById(UserID userId) {
        return userMap.get(userId);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(UserID userId) {

    }

    @Override
    public void userEat(UserID userId, RecipeID recipeId) {

    }
}
