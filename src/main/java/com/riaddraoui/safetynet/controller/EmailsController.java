package com.riaddraoui.safetynet.controller;

import com.riaddraoui.safetynet.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class EmailsController {

    private final EmailService emailService;

    public EmailsController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/communityEmail")
    public List<String> getEmailsByCity(@RequestParam String city) throws IOException {
        return emailService.getEmailsByCity(city);
    }
}
