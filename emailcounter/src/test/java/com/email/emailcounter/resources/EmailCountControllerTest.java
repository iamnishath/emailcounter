package com.email.emailcounter.resources;

import com.email.emailcounter.services.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailCountControllerTest {

    @InjectMocks
    EmailCountController emailCounterController;

    @Mock
    private EmailService emailServiceMock;

    @Test
    public void callsEmailService(){
        ArrayList emails = new ArrayList();
        emailCounterController.countEmails(emails);
        
        verify(emailServiceMock).countEmails(emails);
    }
}