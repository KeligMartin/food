package model.user;

import model.user.User;

public interface UserRepository {
    User findById(String userId);
    void addUser(User user);
    void deleteUser(String userId);
    void userEat(String userId, String recipeId);
}
