package com.ms.email.adapters.outbound.persistence;

import com.ms.email.adapters.outbound.persistence.entities.EmailEntity;
import com.ms.email.aplication.domain.Email;
import com.ms.email.aplication.domain.PageInfo;
import com.ms.email.aplication.ports.EmailRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepositoryPort {

    @Autowired
    private ModelMapper modelMapper;

    private final SpringDataPostgresEmailRepository emailRepository;

    public PostgresEmailRepository (final SpringDataPostgresEmailRepository orderRepository){
        this.emailRepository = orderRepository;
    }

    @Override
    public Email save(Email email) {
        EmailEntity emailEntity = emailRepository.save(modelMapper.map(email, EmailEntity.class));
        return modelMapper.map(emailEntity, Email.class);
    }

    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return emailRepository
                .findAll(pageable)
                .stream()
                .map(entity -> modelMapper.map(entity, Email.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Email> findById(UUID uuid) {
        Optional <EmailEntity> emailEntity = emailRepository.findById(uuid);
        if (emailEntity.isPresent()){
            return Optional.of(modelMapper.map(emailEntity.get(), Email.class));
        }else{
            return Optional.empty();
        }
    }
}