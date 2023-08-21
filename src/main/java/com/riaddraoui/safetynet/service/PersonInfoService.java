package com.riaddraoui.safetynet.service;

import com.riaddraoui.safetynet.model.DataWrapper;
import com.riaddraoui.safetynet.model.MedicalRecord;
import com.riaddraoui.safetynet.model.Person;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonInfoService {
    private final PersonService personService;



    public PersonInfoService(PersonService personService) {
        this.personService = personService;

    }


    public List<Person> getPersonInfo() throws IOException {
        DataWrapper dataWrapper = personService.readDataFromJSON();

        List<Person> personList = dataWrapper.getPersons().stream().map(person -> {
            MedicalRecord medicalRecord = dataWrapper.getMedicalrecords()
                    .stream()
                    .filter(record -> record.getFirstName().equalsIgnoreCase(person.getFirstName()) && record.getLastName().equalsIgnoreCase(person.getLastName()))
                    .findFirst()
                    .orElse(new MedicalRecord()); // Return an empty MedicalRecord if not found

            return new Person(
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAddress(),
                    person.getCity(),
                    person.getZip(),
                    person.getEmail(),
                    person.getPhone(),
                    medicalRecord
            );
        }).collect(Collectors.toList());

        return personList;
    }

    public List<Person> getPersonInfoByFirstNameAndLastName(String firstName, String lastName) throws IOException {
        DataWrapper dataWrapper = personService.readDataFromJSON();

        List<Person> personList = dataWrapper.getPersons().stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName))
                .map(person -> {
                    MedicalRecord medicalRecord = findMedicalRecord(dataWrapper.getMedicalrecords(), person.getFirstName(), person.getLastName());

                    return new Person(
                            person.getFirstName(),
                            person.getLastName(),
                            person.getAddress(),
                            person.getCity(),
                            person.getZip(),
                            person.getEmail(),
                            person.getPhone(),
                            medicalRecord
                    );
                })
                .collect(Collectors.toList());

        return personList;
    }

    private MedicalRecord findMedicalRecord(List<MedicalRecord> medicalRecords, String firstName, String lastName) {
        return medicalRecords.stream()
                .filter(record -> record.getFirstName().equalsIgnoreCase(firstName) && record.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(new MedicalRecord()); // Return an empty MedicalRecord if not found
    }


}

