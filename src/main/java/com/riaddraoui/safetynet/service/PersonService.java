package com.riaddraoui.safetynet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.riaddraoui.safetynet.model.DataWrapper;

import lombok.Data;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@Data
public class PersonService {

    public DataWrapper readDataFromJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("data.json");
        DataWrapper dataWrapper = objectMapper.readValue(resource.getInputStream(), DataWrapper.class);

        return dataWrapper;
    }
}
