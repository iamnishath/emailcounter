package com.email.emailcounter.resources;

import com.email.emailcounter.services.EmailService;
import com.email.emailcounter.validation.EmailList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Validated
public class EmailCountController {

    private final EmailService emailService;

    public EmailCountController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/emailcount")
    public int countEmails(@EmailList @RequestParam(value = "email") List<String> emails) {
        return emailService.countEmails(emails);
    }
}
