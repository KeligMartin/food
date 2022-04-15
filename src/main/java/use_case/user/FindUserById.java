package use_case.user;

import model.user.User;

public class FindUserById {

    private final UserRepository userRepository;

    public FindUserById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String userId) {
        return userRepository.findById(userId);
    }
}
