package com.javajabka.x6_notification.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {

    private final RabbitConfigurationProperties properties;

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue x6NotificationQueue() {
        return new Queue(properties.getQueue(), true);
    }

    @Bean
    public DirectExchange x6NotificationExchange() {
        return new DirectExchange(properties.getExchange());
    }

    @Bean
    public Binding bindingX6Notification(final Queue x6NotificationQueue, final DirectExchange x6NotificationExchange) {
        return BindingBuilder
                .bind(x6NotificationQueue)
                .to(x6NotificationExchange)
                .withQueueName();
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}