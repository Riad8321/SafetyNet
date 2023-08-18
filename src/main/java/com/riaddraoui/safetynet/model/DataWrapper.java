package com.riaddraoui.safetynet.model;

import lombok.Data;

import java.util.List;

@Data
public class DataWrapper {
    private List<Person> persons;
    private List<Firestation> firestations;
    private List<MedicalRecord> medicalrecords;

}