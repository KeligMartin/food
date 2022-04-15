package model.user;

import model.recipe.RecipeID;
import model.user.User;

public interface UserRepository {
    User findById(UserID userId);
    void addUser(User user);
    void deleteUser(UserID userId);
    void userEat(UserID userId, RecipeID recipeId);
}
