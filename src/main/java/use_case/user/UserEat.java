package use_case.user;

import model.recipe.Recipe;
import model.user.User;
import model.user.customexception.IncompatibleRegimeException;
import use_case.recipe.FindRecipeById;

public class UserEat {

    private final FindUserById findUserById;
    private final FindRecipeById findRecipeById;

    public UserEat(FindUserById findUserById, FindRecipeById findRecipeById) {
        this.findUserById = findUserById;
        this.findRecipeById = findRecipeById;
    }

    public void execute(String userId, String recipeId) {
        User user = findUserById.execute(userId);
        Recipe recipe = findRecipeById.execute(recipeId);
        try {
            user.eatRecipe(recipe);
        } catch (IncompatibleRegimeException incompatibleRegimeException) {
            System.out.println(incompatibleRegimeException.getMessage());
        }
    }
}
