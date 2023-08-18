package com.riaddraoui.safetynet.service;

import com.riaddraoui.safetynet.model.DataWrapper;
import com.riaddraoui.safetynet.model.MedicalRecord;
import com.riaddraoui.safetynet.model.Person;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonInfoService {
    private final PersonService personService;

    public PersonInfoService(PersonService personService) {
        this.personService = personService;
    }

    /*public getPersonInfo() throws IOException {
        DataWrapper dataWrapper = personService.readDataFromJSON();

        List<Person> personList = dataWrapper.getPersons().stream().map(person -> {
            List<MedicalRecord> medicalRecord = dataWrapper.getMedicalrecords()
                    .stream()
                    .filter(record -> record.getFirstName().equalsIgnoreCase(person.getFirstName()) && record.getLastName().equalsIgnoreCase(person.getLastName())).collect(Collectors.toList());


            return new Person(
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAddress(),
                    person.getCity(),
                    person.getZip(),
                    person.getEmail(),
                    person.getPhone(),
                    person.getMedications(),
                    person.getAllergies()

            );
        }).collect(Collectors.toList());

        return personList;
    }*/

    public List<String> getEmailsByCity(String city) throws IOException {
        DataWrapper dataWrapper = personService.readDataFromJSON();
        List<String> emails = dataWrapper.getPersons()
                .stream()
                .filter(person -> person.getCity().equalsIgnoreCase(city))
                .map(Person::getEmail)
                .distinct()
                .collect(Collectors.toList());

        return emails;
    }
}

