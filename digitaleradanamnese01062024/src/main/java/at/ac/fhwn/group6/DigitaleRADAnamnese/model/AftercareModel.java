package at.ac.fhwn.group6.DigitaleRADAnamnese.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AftercareModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ivContrast = false;
    private Boolean extravasation = false;
    private Boolean diabetes = false;
    private Boolean sedative = false;

    @ManyToOne
    @JoinColumn(name = "patientID")
    private GeneralAnswersModel patientModel;

    @OneToOne
    @JoinColumn(name = "specificAnswerID")
    private SpecificAnswersModel specificAnswersModel;
}
