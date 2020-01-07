package com.email.emailcounter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {

    public static final String AT_SYMBOL = "@";
    private static final int USERNAME_INDEx = 0;
    private static final int DOMAIN_INDEX = 1;

    private String username;
    private String domain;

    public Email(String emailAddress) {
        String[] emailFragments = emailAddress.split(AT_SYMBOL);
        username = emailFragments[USERNAME_INDEx];
        domain = emailFragments[DOMAIN_INDEX];
    }

    public Email(Email email) {
        this.username = email.username;
        this.domain = email.domain;
    }

    public String value() {
        return username + AT_SYMBOL + domain;
    }
}
