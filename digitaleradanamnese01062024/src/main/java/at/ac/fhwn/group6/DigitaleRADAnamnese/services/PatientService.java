package at.ac.fhwn.group6.DigitaleRADAnamnese.services;

import at.ac.fhwn.group6.DigitaleRADAnamnese.model.AftercareModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.GeneralAnswersModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.SpecificAnswersModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.model.UserModel;
import at.ac.fhwn.group6.DigitaleRADAnamnese.repositories.AftercareRepository;
import at.ac.fhwn.group6.DigitaleRADAnamnese.repositories.GeneralAnswersRepository;
import at.ac.fhwn.group6.DigitaleRADAnamnese.repositories.SpecificAnswersRepository;
import at.ac.fhwn.group6.DigitaleRADAnamnese.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final AftercareRepository aftercareRepository;
    private final GeneralAnswersRepository generalAnswersRepository;
    private final SpecificAnswersRepository specificAnswersRepository;
    private final UserRepository userRepository;

    @Autowired
    public PatientService(AftercareRepository aftercareRepository, GeneralAnswersRepository generalAnswersRepository, SpecificAnswersRepository specificAnswersRepository, UserRepository userRepository) {
        this.aftercareRepository = aftercareRepository;
        this.generalAnswersRepository = generalAnswersRepository;
        this.specificAnswersRepository = specificAnswersRepository;
        this.userRepository = userRepository;
    }

    public Optional<GeneralAnswersModel> findByUsername(String username) {
        return generalAnswersRepository.findByUserModel_Username(username);
    }

    public Optional<AftercareModel> findAftercareByPatientId(Long patientId) {
        return aftercareRepository.findByPatientModel_Id(patientId);
    }

    public List<SpecificAnswersModel> findSpecificAnswersByPatientId(Long patientId) {
        return specificAnswersRepository.findByPatientModel_Id(patientId);
    }

    public Optional<SpecificAnswersModel> findSpecificAnswersById(Long id) {
        return specificAnswersRepository.findById(id);
    }

    public Optional<AftercareModel> findAftercareBySpecificAnswerId(Long specificAnswerId) {
        return aftercareRepository.findBySpecificAnswersModel_Id(specificAnswerId);
    }

    public GeneralAnswersModel saveOrUpdatePatient(GeneralAnswersModel patient, String username) {
        Optional<UserModel> userOptional = userRepository.findUserByUsername(username);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            Optional<GeneralAnswersModel> existingPatient = generalAnswersRepository.findByUserModel_Username(username);

            if (existingPatient.isPresent()) {
                GeneralAnswersModel patientToUpdate = existingPatient.get();
                patientToUpdate.setFirstname(patient.getFirstname());
                patientToUpdate.setLastname(patient.getLastname());
                patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
                patientToUpdate.setGender(patient.getGender());
                patientToUpdate.setAddress(patient.getAddress());
                patientToUpdate.setTelephoneNumber(patient.getTelephoneNumber());
                patientToUpdate.setBodyHeight(patient.getBodyHeight());
                patientToUpdate.setBodyWeight(patient.getBodyWeight());
                return generalAnswersRepository.save(patientToUpdate);
            } else {
                patient.setUserModel(user);
                return generalAnswersRepository.save(patient);
            }
        }

        throw new RuntimeException("User not found");
    }

    public void saveSpecificAnswers(SpecificAnswersModel specificAnswers, String username) {
        Optional<GeneralAnswersModel> patientOptional = generalAnswersRepository.findByUserModel_Username(username);
        if (patientOptional.isPresent()) {
            GeneralAnswersModel patient = patientOptional.get();
            specificAnswers.setPatientModel(patient);
            specificAnswersRepository.save(specificAnswers);
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

    public void saveAftercareInfo(AftercareModel aftercare, String username, Long specificAnswerId) {
        Optional<GeneralAnswersModel> patientOptional = generalAnswersRepository.findByUserModel_Username(username);
        Optional<SpecificAnswersModel> specificAnswersOptional = specificAnswersRepository.findById(specificAnswerId);
        if (patientOptional.isPresent() && specificAnswersOptional.isPresent()) {
            GeneralAnswersModel patient = patientOptional.get();
            SpecificAnswersModel specificAnswers = specificAnswersOptional.get();
            aftercare.setPatientModel(patient);
            aftercare.setSpecificAnswersModel(specificAnswers);
            aftercareRepository.save(aftercare);
        } else {
            throw new RuntimeException("Patient or Specific Answer not found");
        }
    }

}
