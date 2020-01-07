package com.email.emailcounter.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceImplTest {

    @InjectMocks
    private EmailServiceImpl emailService;

    @Test
    void returnsCorrectCountNotRepeat() {
        int emailCount = emailService.countEmails(newArrayList("a@b.com", "c@d.com"));
        assertEquals(2, emailCount);
    }

    @Test
    void returnsCorrectCountSimpleRepeat() {
        int emailCount = emailService.countEmails(newArrayList("a@b.com", "a@b.com"));
        assertEquals(1, emailCount);
    }

    @Test
    void returnsCorrectCountRepeatWithPlus() {
        int emailCount = emailService.countEmails(newArrayList("a@b.com", "a cat@b.com"));
        assertEquals(1, emailCount);
    }

    @Test
    void returnsCorrectCountRepeatWithDot() {
        int emailCount = emailService.countEmails(newArrayList("acat@b.com", "a.cat@b.com"));
        assertEquals(1, emailCount);
    }

    @Test
     void returnsCorrectCountRepeatWithDotAndPlus() {
        int emailCount = emailService.countEmails(newArrayList("acat@b.com", "a.cat ...@b.com", "acat+ .....@b.com"));
        assertEquals(1, emailCount);
    }
}