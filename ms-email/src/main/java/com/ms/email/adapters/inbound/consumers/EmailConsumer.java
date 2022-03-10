package com.ms.email.adapters.inbound.consumers;

import com.ms.email.adapters.dtos.EmailDto;
import com.ms.email.aplication.domain.Email;
import com.ms.email.aplication.services.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailServiceImpl service;

    @RabbitListener (queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        this.service.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail().toString());
    }
}
