package at.ac.fhwn.group6.DigitaleRADAnamnese.repositories;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.GeneralAnswersModel;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Registered
public interface GeneralAnswersRepository extends JpaRepository<GeneralAnswersModel, Long> {
    Optional<GeneralAnswersModel> findByUserModel_Username(String username);
}
