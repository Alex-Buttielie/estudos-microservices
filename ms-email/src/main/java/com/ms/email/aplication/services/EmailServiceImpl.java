package com.ms.email.aplication.services;

import com.ms.email.aplication.domain.PageInfo;
import com.ms.email.aplication.domain.enums.StatusEmail;
import com.ms.email.aplication.domain.Email;
import com.ms.email.aplication.ports.EmailRepositoryPort;
import com.ms.email.aplication.ports.EmailServicePort;
import com.ms.email.aplication.ports.SendEmailServicePort;
import org.springframework.mail.MailException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmailServiceImpl implements EmailServicePort {

    private final EmailRepositoryPort emailRepositoryPort;
    private final SendEmailServicePort sendEmailServicePort;

    public EmailServiceImpl(final EmailRepositoryPort emailRepository,
                            final SendEmailServicePort sendEmailServicePort) {
        this.emailRepositoryPort = emailRepository;
        this.sendEmailServicePort = sendEmailServicePort;
    }

    @Override
    public Email sendEmail(Email email) {
        try {
            this.addDataCreationEmail(email);
            this.sendEmailServicePort.sendEmailSmtp(email);
            this.updateEmailStatusSent(email);
        } catch (MailException e){
            this.updateEmailStatusNotSent(email);
        } finally {
            return this.persistsEmail(email);
        }
    }

    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        return emailRepositoryPort.findAll(pageInfo);
    }

    @Override
    public Optional findById(UUID uuid) {
        return this.emailRepositoryPort.findById(uuid);
    }

    private Email persistsEmail(Email email) {
        return emailRepositoryPort.save(email);
    }

    private void updateEmailStatusNotSent(Email email) {
        email.setStatusEmail(StatusEmail.ERROR);
    }

    private void addDataCreationEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
    }

    private void updateEmailStatusSent(Email email) {
        email.setStatusEmail(StatusEmail.SENT);
    }
}
