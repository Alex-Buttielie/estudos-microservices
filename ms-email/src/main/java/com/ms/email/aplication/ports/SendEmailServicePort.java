package com.ms.email.aplication.ports;

import com.ms.email.aplication.domain.Email;

public interface SendEmailServicePort {
    void sendEmailSmtp(Email email);
}
