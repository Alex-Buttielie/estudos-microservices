package com.ms.email.adapters.outbound.smtp;

import com.ms.email.aplication.domain.Email;
import com.ms.email.aplication.domain.enums.StatusEmail;
import com.ms.email.aplication.ports.SendEmailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SmptSendEmailService implements SendEmailServicePort {

    @Autowired
    private JavaMailSender sender;

    public void sendEmailSmtp(Email email) {
        this.performsSendingTheEmail(email);
    }

    private void performsSendingTheEmail(Email email) {
        this.sender.send(this.picksUpFilledEmailObject(email));
    }

    private SimpleMailMessage picksUpFilledEmailObject(Email email) {
        SimpleMailMessage bodyEmailForShipping = new SimpleMailMessage();
        bodyEmailForShipping.setFrom(email.getEmailFrom());
        bodyEmailForShipping.setTo(email.getEmailTo());
        bodyEmailForShipping.setSubject(email.getSubject());
        bodyEmailForShipping.setText(email.getText());
        return  bodyEmailForShipping;
    }


}
