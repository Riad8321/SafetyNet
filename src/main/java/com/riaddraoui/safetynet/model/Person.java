package com.riaddraoui.safetynet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Person {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip")
    private Integer zip;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("medicalRecord") // Reference to a single MedicalRecord
    private MedicalRecord medicalRecord;

    public Person() {
    }

    public Person(String firstName, String lastName, String address, String city, Integer zip, String phone, String email, MedicalRecord medicalRecord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
        this.medicalRecord = medicalRecord;
    }
}
