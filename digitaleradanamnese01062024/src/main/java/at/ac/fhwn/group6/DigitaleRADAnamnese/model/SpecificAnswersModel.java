package at.ac.fhwn.group6.DigitaleRADAnamnese.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SpecificAnswersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicalHistory = "";
    private Boolean previousRadiologicalProcedures = false;
    private String knownAllergies = "";
    private Boolean anticoagulantMedication = false;
    private Boolean metalImplants = false;
    private Boolean cardiovascularDiseases = false;
    private Boolean pulmonaryAirwayDisease = false;
    private Boolean malignantDisease = false;
    private Boolean metabolicDisease = false;
    private Boolean liverDisease = false;
    private Boolean gastrointestinalDisease = false;
    private Boolean chemotherapy = false;
    private Boolean pregnant = false;
    private Boolean breastfeeding = false;
    private Boolean kidneyXRay = false;
    private Boolean legVeinsDepiction = false;
    private Boolean bloodVesselXRay = false;
    private Boolean adverseReactions = false;
    private String adverseReactionsDetails = "";
    private Boolean priorAllergicReaction = false;
    private Boolean nausea = false;
    private Boolean asthmaAttack = false;
    private Boolean skinRash = false;
    private Boolean seizures = false;
    private Boolean chills = false;
    private Boolean diagnosedAsthma = false;
    private Boolean iodineAllergy = false;
    private Boolean thyroidGlandDiagnosis = false;
    private Double TSHResult = 0.0;
    private Boolean diabetesMellitus = false;
    private Boolean takeMetformin = false;
    private Boolean additionalInfoMetformin = false;
    private Boolean kidneyDisease = false;
    private Boolean renalInsufficiency = false;
    private Boolean kidneyTransplant = false;
    private Boolean kidneyDysfunctionDyalisis = false;
    private Boolean kidneyCancer = false;
    private Double creatinineResult = 0.0;
    private Boolean additionalInfoCreatinine = false;
    private Boolean kahlersDisease = false;
    private Boolean diagnosedThyroidDisease = false;
    private Boolean pacemaker = false;
    private String pacemakerBrand = "";
    private Integer pacemakerPlacementYear = 0;
    private Boolean claustrophobia = false;
    private Boolean sedativePreferred = false;
    private String preferredSedative = "";

    @ManyToOne
    @JoinColumn(name = "patientID")
    private GeneralAnswersModel patientModel;

    @OneToOne(mappedBy = "specificAnswersModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private AftercareModel aftercareModel;
}
