package org.shabbir.digitalpatientanamnesis.services;

import org.shabbir.digitalpatientanamnesis.model.UserModel;
import org.shabbir.digitalpatientanamnesis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }
    public Optional<UserModel> SignIn(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
