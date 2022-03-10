package com.ms.email.adapters.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Value("amqps://usnpycdk:8gJv7btZ4yi66-mEJVkwOeEpIQuq784b@beaver.rmq.cloudamqp.com/usnpycdk")
    private String uri;

    @Bean
    public ConnectionFactory rabbitConnetionsFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUri(this.uri);
        return connectionFactory;
    }

    @Bean
    public Queue queue() {
        return new Queue(this.queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
