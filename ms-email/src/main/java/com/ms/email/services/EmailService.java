package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    @Autowired
    private JavaMailSender sender;

    public EmailModel sendEmail(EmailModel emailModel) {
        try {
            this.addDataCreationEmail(emailModel);
            this.performsSendingTheEmail(emailModel);
            this.updateEmailStatusSent(emailModel);
        } catch (MailException e){
            this.updateEmailStatusNotSent(emailModel);
        } finally {
            return this.persistsEmail(emailModel);
        }
    }

    private EmailModel persistsEmail(EmailModel emailModel) {
        return repository.save(emailModel);
    }

    private void performsSendingTheEmail(EmailModel emailModel) {
        this.sender.send(this.picksUpFilledEmailObject(emailModel));
    }

    private void updateEmailStatusSent(EmailModel emailModel) {
        emailModel.setStatusEmail(StatusEmail.SENT);
    }

    private void updateEmailStatusNotSent(EmailModel emailModel) {
        emailModel.setStatusEmail(StatusEmail.ERROR);
    }

    private SimpleMailMessage picksUpFilledEmailObject(EmailModel emailModel) {
        SimpleMailMessage bodyEmailForShipping = new SimpleMailMessage();
        bodyEmailForShipping.setFrom(emailModel.getEmailFrom());
        bodyEmailForShipping.setTo(emailModel.getEmailTo());
        bodyEmailForShipping.setSubject(emailModel.getSubject());
        bodyEmailForShipping.setText(emailModel.getText());
        return  bodyEmailForShipping;
    }

    private void addDataCreationEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
    }
}
