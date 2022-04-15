package use_case.user;

import model.user.UserID;
import model.user.UserRepository;

public class DeleteUser {

    private final UserRepository users;

    public DeleteUser(UserRepository users){
        this.users = users;
    }

    public void execute(UserID id) {
        this.users.deleteUser(id);
    }
}
