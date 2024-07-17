package com.example.coreservice.config;

import com.example.coreservice.sevice.RabbitConsumerMessageService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class RabbitConfig {
    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RabbitConsumerMessageService listener) {
        return new MessageListenerAdapter(listener, "consumeMessage");
    }

    @Bean
    public Declarables declarables( @Value("#{${pmp.rabbit.queues}}") Map<String, String> keysQueues,
                                    @Value("${rabbitmq.exchange.name}") String exchangeName) {

        List<Declarable> declarables = new ArrayList<>();
        TopicExchange topicExchange = new TopicExchange(exchangeName);
        declarables.add(topicExchange);
        keysQueues.entrySet()
                .forEach(entry -> {
                    Queue queue = new Queue(entry.getKey());
                    Binding binding = BindingBuilder.bind(queue).to(topicExchange).with(entry.getValue());
                    declarables.add(queue);
                    declarables.add(binding);
                });

        return new Declarables(declarables);
    }
}
