package use_case.user;

import model.user.User;
import model.user.Users;

public class AddUser {

    private final Users users;

    public AddUser(Users users) {
        this.users = users;
    }

    public void execute(User user) {
        users.addUser(user);
    }
}
