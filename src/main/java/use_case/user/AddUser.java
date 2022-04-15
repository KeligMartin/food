package use_case.user;

import model.user.User;
import model.user.UserRepository;

public class AddUser {

    private final UserRepository users;

    public AddUser(UserRepository users) {
        this.users = users;
    }

    public void execute(User user) {
        users.addUser(user);
    }
}
