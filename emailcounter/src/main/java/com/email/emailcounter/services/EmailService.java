package com.email.emailcounter.services;

import java.util.List;

public interface EmailService {
    int countEmails(List<String> emails);
}
