package use_case.user;

import model.user.UserRepository;

public class DeleteUser {

    private final UserRepository users;

    public DeleteUser(UserRepository users){
        this.users = users;
    }

    public void execute(String id) {
        this.users.deleteUser(id);
    }
}
