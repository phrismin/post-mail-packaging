package com.example.coreservice.sevice.impl;

import com.example.coreservice.domain.MessageDto;
import com.example.coreservice.repository.MessageRepository;
import com.example.coreservice.sevice.MessageService;
import com.example.coreservice.sevice.RabbitConsumerMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitConsumerMessageImpl implements RabbitConsumerMessageService {

    private final MessageService messageService;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Override
    @RabbitListener(queues = "message.process")
    public void processMessage(MessageDto messageDto) {
        log.info("Получено на обработку в core-service:{}", messageDto.toString());
        String template = messageService.findTemplateById(messageDto.getTemplateId());
        Integer groupUsers = messageDto.getGroupUsers();

        String message = "test";
        sendMessageToSmtpService(message);
    }

    private void sendMessageToSmtpService(String message) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        rabbitTemplate.getMessageConverter().toMessage(message, messageProperties);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
        log.info("Письмо отправлено на обработку в smtp-mail-service:{}", message);
    }


    //updateStatus, dto (uniqueMessage, status)
}
