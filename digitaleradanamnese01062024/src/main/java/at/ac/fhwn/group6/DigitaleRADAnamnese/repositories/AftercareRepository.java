package at.ac.fhwn.group6.DigitaleRADAnamnese.repositories;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.AftercareModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AftercareRepository extends JpaRepository<AftercareModel, Long> {
    Optional<AftercareModel> findByPatientModel_Id(Long patientId);
    Optional<AftercareModel> findBySpecificAnswersModel_Id(Long specificAnswerId);
}
