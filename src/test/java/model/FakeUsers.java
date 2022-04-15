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
    Map<UserID, User> userMap;

    public FakeUsers() {
        userMap = new HashMap<>();
        User user1 = User.builder()
                .username("user1")
                .password("password")
                .dietaryRegimes(new ArrayList<>(List.of(DietaryRegimes.VEGAN, DietaryRegimes.GLUTEN_INTOLERANT)))
                .caloriesConsumed(400)
                .build();
        User user2 = User.builder()
                .username("user")
                .password("password")
                .dietaryRegimes(new ArrayList<>(List.of(DietaryRegimes.GLUTEN_INTOLERANT)))
                .caloriesConsumed(300)
                .build();
        User user3 = User.builder()
                .username("user")
                .password("password")
                .dietaryRegimes(new ArrayList<>(List.of(DietaryRegimes.VEGAN)))
                .caloriesConsumed(500)
                .build();

        userMap.put(new UserID("001"), user1);
        userMap.put(new UserID("002"), user2);
        userMap.put(new UserID("003"), user3);
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
