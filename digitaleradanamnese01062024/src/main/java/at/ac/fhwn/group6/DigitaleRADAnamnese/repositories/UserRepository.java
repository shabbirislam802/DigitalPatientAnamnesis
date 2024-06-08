package at.ac.fhwn.group6.DigitaleRADAnamnese.repositories;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findUserByUsername(String username);
}
