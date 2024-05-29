package org.shabbir.digitalpatientanamnesis.model;

import jakarta.persistence.*;

@Entity
public class PatientQuestionnaireSpecModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicalHistory;
    private boolean previousRadiologicalProcedures;
    private String knownAllergies;
    private boolean anticoagulantMedication;

    private boolean metalImplants;

    private boolean cardiovascularDiseases;

    private boolean pulmonaryAirwayDisease;

    private boolean malignantDisease;

    private boolean metabolicDisease;

    private boolean liverDisease;

    private boolean gastrointestinalDisease;

    private boolean chemotherapy;

    private boolean pregnant;

    private boolean breastfeeding;

    private boolean kidneyXRay;

    private boolean legVeinsDepiction;

    private boolean bloodVesselXRay;

    private boolean adverseReactions;

    private String adverseReactionsDetails;

    private boolean priorAllergicReaction;

    private boolean nausea;

    private boolean asthmaAttack;

    private boolean skinRash;

    private boolean seizures;

    private boolean chills;

    private boolean diagnosedAsthma;

    private boolean iodineAllergy;

    private boolean thyroidGlandDiagnosis;

    private double TSHResult;

    private boolean diabetesMellitus;

    private boolean takeMetformin;

    private boolean additionalInfoMetformin;

    private boolean kidneyDisease;

    private boolean renalInsufficiency;

    private boolean kidneyTransplant;

    private boolean kidneyDysfunctionDyalisis;

    private boolean kidneyCancer;

    private double creatinineResult;

    private boolean additionalInfoCreatinine;

    private boolean kahlersDisease;

    private boolean diagnosedThyroidDisease;

    private boolean pacemaker;

    private String pacemakerBrand;

    private int pacemakerPlacementYear;

    private boolean claustrophobia;

    @ManyToOne
    @JoinColumn(name = "patientID")
    private PatientModel patientModel;

    public boolean isPreviousRadiologicalProcedures() {
        return previousRadiologicalProcedures;
    }

    public boolean isAnticoagulantMedication() {
        return anticoagulantMedication;
    }

    public void setAnticoagulantMedication(boolean anticoagulantMedication) {
        this.anticoagulantMedication = anticoagulantMedication;
    }

    public boolean isMetalImplants() {
        return metalImplants;
    }

    public void setMetalImplants(boolean metalImplants) {
        this.metalImplants = metalImplants;
    }

    public boolean isCardiovascularDiseases() {
        return cardiovascularDiseases;
    }

    public void setCardiovascularDiseases(boolean cardiovascularDiseases) {
        this.cardiovascularDiseases = cardiovascularDiseases;
    }

    public boolean isPulmonaryAirwayDisease() {
        return pulmonaryAirwayDisease;
    }

    public void setPulmonaryAirwayDisease(boolean pulmonaryAirwayDisease) {
        this.pulmonaryAirwayDisease = pulmonaryAirwayDisease;
    }

    public boolean isMalignantDisease() {
        return malignantDisease;
    }

    public void setMalignantDisease(boolean malignantDisease) {
        this.malignantDisease = malignantDisease;
    }

    public boolean isMetabolicDisease() {
        return metabolicDisease;
    }

    public void setMetabolicDisease(boolean metabolicDisease) {
        this.metabolicDisease = metabolicDisease;
    }

    public boolean isLiverDisease() {
        return liverDisease;
    }

    public void setLiverDisease(boolean liverDisease) {
        this.liverDisease = liverDisease;
    }

    public boolean isGastrointestinalDisease() {
        return gastrointestinalDisease;
    }

    public void setGastrointestinalDisease(boolean gastrointestinalDisease) {
        this.gastrointestinalDisease = gastrointestinalDisease;
    }

    public boolean isChemotherapy() {
        return chemotherapy;
    }

    public void setChemotherapy(boolean chemotherapy) {
        this.chemotherapy = chemotherapy;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public boolean isBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(boolean breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public boolean isKidneyXRay() {
        return kidneyXRay;
    }

    public void setKidneyXRay(boolean kidneyXRay) {
        this.kidneyXRay = kidneyXRay;
    }

    public boolean isLegVeinsDepiction() {
        return legVeinsDepiction;
    }

    public void setLegVeinsDepiction(boolean legVeinsDepiction) {
        this.legVeinsDepiction = legVeinsDepiction;
    }

    public boolean isBloodVesselXRay() {
        return bloodVesselXRay;
    }

    public void setBloodVesselXRay(boolean bloodVesselXRay) {
        this.bloodVesselXRay = bloodVesselXRay;
    }

    public boolean isAdverseReactions() {
        return adverseReactions;
    }

    public void setAdverseReactions(boolean adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    public String getAdverseReactionsDetails() {
        return adverseReactionsDetails;
    }

    public void setAdverseReactionsDetails(String adverseReactionsDetails) {
        this.adverseReactionsDetails = adverseReactionsDetails;
    }

    public boolean isPriorAllergicReaction() {
        return priorAllergicReaction;
    }

    public void setPriorAllergicReaction(boolean priorAllergicReaction) {
        this.priorAllergicReaction = priorAllergicReaction;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isAsthmaAttack() {
        return asthmaAttack;
    }

    public void setAsthmaAttack(boolean asthmaAttack) {
        this.asthmaAttack = asthmaAttack;
    }

    public boolean isSkinRash() {
        return skinRash;
    }

    public void setSkinRash(boolean skinRash) {
        this.skinRash = skinRash;
    }

    public boolean isSeizures() {
        return seizures;
    }

    public void setSeizures(boolean seizures) {
        this.seizures = seizures;
    }

    public boolean isChills() {
        return chills;
    }

    public void setChills(boolean chills) {
        this.chills = chills;
    }

    public boolean isDiagnosedAsthma() {
        return diagnosedAsthma;
    }

    public void setDiagnosedAsthma(boolean diagnosedAsthma) {
        this.diagnosedAsthma = diagnosedAsthma;
    }

    public boolean isIodineAllergy() {
        return iodineAllergy;
    }

    public void setIodineAllergy(boolean iodineAllergy) {
        this.iodineAllergy = iodineAllergy;
    }

    public boolean isThyroidGlandDiagnosis() {
        return thyroidGlandDiagnosis;
    }

    public void setThyroidGlandDiagnosis(boolean thyroidGlandDiagnosis) {
        this.thyroidGlandDiagnosis = thyroidGlandDiagnosis;
    }

    public double getTSHResult() {
        return TSHResult;
    }

    public void setTSHResult(double TSHResult) {
        this.TSHResult = TSHResult;
    }

    public boolean isDiabetesMellitus() {
        return diabetesMellitus;
    }

    public void setDiabetesMellitus(boolean diabetesMellitus) {
        this.diabetesMellitus = diabetesMellitus;
    }

    public boolean isTakeMetformin() {
        return takeMetformin;
    }

    public void setTakeMetformin(boolean takeMetformin) {
        this.takeMetformin = takeMetformin;
    }

    public boolean isAdditionalInfoMetformin() {
        return additionalInfoMetformin;
    }

    public void setAdditionalInfoMetformin(boolean additionalInfoMetformin) {
        this.additionalInfoMetformin = additionalInfoMetformin;
    }

    public boolean isKidneyDisease() {
        return kidneyDisease;
    }

    public void setKidneyDisease(boolean kidneyDisease) {
        this.kidneyDisease = kidneyDisease;
    }

    public boolean isRenalInsufficiency() {
        return renalInsufficiency;
    }

    public void setRenalInsufficiency(boolean renalInsufficiency) {
        this.renalInsufficiency = renalInsufficiency;
    }

    public boolean isKidneyTransplant() {
        return kidneyTransplant;
    }

    public void setKidneyTransplant(boolean kidneyTransplant) {
        this.kidneyTransplant = kidneyTransplant;
    }

    public boolean isKidneyDysfunctionDyalisis() {
        return kidneyDysfunctionDyalisis;
    }

    public void setKidneyDysfunctionDyalisis(boolean kidneyDysfunctionDyalisis) {
        this.kidneyDysfunctionDyalisis = kidneyDysfunctionDyalisis;
    }

    public boolean isKidneyCancer() {
        return kidneyCancer;
    }

    public void setKidneyCancer(boolean kidneyCancer) {
        this.kidneyCancer = kidneyCancer;
    }

    public double getCreatinineResult() {
        return creatinineResult;
    }

    public void setCreatinineResult(double creatinineResult) {
        this.creatinineResult = creatinineResult;
    }

    public boolean isAdditionalInfoCreatinine() {
        return additionalInfoCreatinine;
    }

    public void setAdditionalInfoCreatinine(boolean additionalInfoCreatinine) {
        this.additionalInfoCreatinine = additionalInfoCreatinine;
    }

    public boolean isKahlersDisease() {
        return kahlersDisease;
    }

    public void setKahlersDisease(boolean kahlersDisease) {
        this.kahlersDisease = kahlersDisease;
    }

    public boolean isDiagnosedThyroidDisease() {
        return diagnosedThyroidDisease;
    }

    public void setDiagnosedThyroidDisease(boolean diagnosedThyroidDisease) {
        this.diagnosedThyroidDisease = diagnosedThyroidDisease;
    }

    public boolean isPacemaker() {
        return pacemaker;
    }

    public void setPacemaker(boolean pacemaker) {
        this.pacemaker = pacemaker;
    }

    public String getPacemakerBrand() {
        return pacemakerBrand;
    }

    public void setPacemakerBrand(String pacemakerBrand) {
        this.pacemakerBrand = pacemakerBrand;
    }

    public int getPacemakerPlacementYear() {
        return pacemakerPlacementYear;
    }

    public void setPacemakerPlacementYear(int pacemakerPlacementYear) {
        this.pacemakerPlacementYear = pacemakerPlacementYear;
    }

    public boolean isClaustrophobia() {
        return claustrophobia;
    }

    public void setClaustrophobia(boolean claustrophobia) {
        this.claustrophobia = claustrophobia;
    }

    public String getPreferredSedative() {
        return preferredSedative;
    }

    public void setPreferredSedative(String preferredSedative) {
        this.preferredSedative = preferredSedative;
    }



    public boolean isSedativePreferred() {
        return sedativePreferred;
    }

    public void setSedativePreferred(boolean sedativePreferred) {
        this.sedativePreferred = sedativePreferred;
    }

    private boolean sedativePreferred;

    private String preferredSedative;
    public String getMedicalHistory() {
        return medicalHistory;
    }
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean getPreviousRadiologicalProcedures() {
        return previousRadiologicalProcedures;
    }
    public void setPreviousRadiologicalProcedures(boolean previousRadiologicalProcedures) {
        this.previousRadiologicalProcedures = previousRadiologicalProcedures;
    }
    public String getKnownAllergies() {
        return knownAllergies;
    }
    public void setKnownAllergies(String knownAllergies) {
        this.knownAllergies = knownAllergies;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
