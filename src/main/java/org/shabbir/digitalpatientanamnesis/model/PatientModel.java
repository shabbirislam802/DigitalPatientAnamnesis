package org.shabbir.digitalpatientanamnesis.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String telephoneNumber;

    @OneToOne
    @JoinColumn(name = "userID")
    private UserModel userModel;

    @OneToMany(mappedBy = "patientModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PatientQuestionnaireSpecModel> patientQuestionnaireSpecModel;

    public double getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(double bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public double getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(double bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    private double bodyWeight;

    private double bodyHeight;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContactNumber() {
        return telephoneNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.telephoneNumber = contactNumber;
    }

}
