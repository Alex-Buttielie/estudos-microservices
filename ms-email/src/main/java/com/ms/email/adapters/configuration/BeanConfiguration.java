package com.ms.email.adapters.configuration;

import com.ms.email.MsEmailApplication;
import com.ms.email.aplication.ports.EmailRepositoryPort;
import com.ms.email.aplication.ports.SendEmailServicePort;
import com.ms.email.aplication.services.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MsEmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort emailRepositoryPort, SendEmailServicePort sendEmailServicePort){
        return new EmailServiceImpl(emailRepositoryPort, sendEmailServicePort );
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

