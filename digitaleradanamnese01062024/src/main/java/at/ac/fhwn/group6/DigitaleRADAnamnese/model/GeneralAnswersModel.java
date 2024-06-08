package at.ac.fhwn.group6.DigitaleRADAnamnese.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GeneralAnswersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String telephoneNumber;
    private double bodyWeight;
    private double bodyHeight;

   @OneToOne
    @JoinColumn(name = "userID")
    private UserModel userModel;

   @OneToMany(mappedBy = "patientModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpecificAnswersModel> patientQuestionnaireSpecModel;

    @OneToMany(mappedBy = "patientModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AftercareModel> aftercareModels;
}
