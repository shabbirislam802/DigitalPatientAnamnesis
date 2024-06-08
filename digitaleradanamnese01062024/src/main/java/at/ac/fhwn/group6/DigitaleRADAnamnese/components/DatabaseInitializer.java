package at.ac.fhwn.group6.DigitaleRADAnamnese.components;

import at.ac.fhwn.group6.DigitaleRADAnamnese.enums.RoleEnum;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.UserModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public DatabaseInitializer(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (userRepository.findUserByUsername("Admin").isEmpty()) {
            UserModel adminUser = new UserModel();
            adminUser.setUsername("Admin");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            adminUser.setEmail("admin@example.com");
            adminUser.setRole(RoleEnum.ADMIN);
            userRepository.save(adminUser);
        }
    }
}
