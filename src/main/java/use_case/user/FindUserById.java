package use_case.user;

import model.user.User;
import model.user.UserID;
import model.user.UserRepository;

public class FindUserById {

    private final UserRepository userRepository;

    public FindUserById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UserID userId) {
        return userRepository.findById(userId);
    }
}
