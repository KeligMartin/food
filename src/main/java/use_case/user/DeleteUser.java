package use_case.user;

import model.user.Users;

public class DeleteUser {

    private final Users users;

    public DeleteUser(Users users){
        this.users = users;
    }

    public void execute(Integer id) {
        this.users.deleteUser(id);
    }
}
