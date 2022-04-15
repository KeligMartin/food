package use_case.user;

import model.recipe.Recipe;
import model.recipe.RecipeID;
import model.user.User;
import model.user.UserID;
import model.user.UserRepository;
import model.user.customexception.IncompatibleRegimeException;
import use_case.recipe.FindRecipeById;

public class UserEat {

    private final FindUserById findUserById;
    private final FindRecipeById findRecipeById;
    private final UserRepository repository;

    public UserEat(FindUserById findUserById, FindRecipeById findRecipeById, UserRepository repository) {
        this.findUserById = findUserById;
        this.findRecipeById = findRecipeById;
        this.repository = repository;
    }

    public void execute(UserID userId, RecipeID recipeId) {
        User user = findUserById.execute(userId);
        Recipe recipe = findRecipeById.execute(recipeId);
        this.repository.userEat(userId, recipeId);
    }
}
