package com.email.emailcounter.services.impl;

import com.email.emailcounter.domain.Email;
import com.email.emailcounter.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Override
    public int countEmails(List<String> emails) {
        Set<String> uniqueEmails = emails.stream().map(Email::new).map(this::sanitize).collect(Collectors.toSet());
        return uniqueEmails.size();
    }

    private String sanitize(Email email) {
        Email result = new Email(email);
        if (result.getUsername().contains("+")) {
            result = sanitizeForPlusInId(result);
        }
        if (result.getUsername().contains(" ")) {
            result = sanitizeForSpaceInId(result);
        }
        if (result.getUsername().contains(".")) {
            result = sanitizeForDot(result);
        }
        return result.value();
    }

    private Email sanitizeForSpaceInId(Email email) {
        return new Email(email.getUsername().substring(0, email.getUsername().indexOf(" ")), email.getDomain());
    }

    private Email sanitizeForPlusInId(Email email) {
        return new Email(email.getUsername().replace("+", " "), email.getDomain());
    }

    private Email sanitizeForDot(Email email) {
        return new Email(email.getUsername().replace(".", ""), email.getDomain());
    }
}
