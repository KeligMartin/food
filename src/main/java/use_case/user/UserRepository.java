package use_case.user;

import model.user.User;

public interface UserRepository {
    User findById(User userId);
}
