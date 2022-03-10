package com.ms.email.aplication.ports;

import com.ms.email.aplication.domain.Email;
import com.ms.email.aplication.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmailRepositoryPort {
        Email save (Email email);
        List<Email> findAll (PageInfo pageable);
        Optional findById (UUID uuid);
}
