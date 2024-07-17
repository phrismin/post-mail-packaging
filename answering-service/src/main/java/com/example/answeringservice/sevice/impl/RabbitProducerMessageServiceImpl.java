package com.example.answeringservice.sevice.impl;

import com.example.answeringservice.domain.MessageDto;
import com.example.answeringservice.sevice.RabbitProducerMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitProducerMessageServiceImpl implements RabbitProducerMessageService {
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(MessageDto dto) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        rabbitTemplate.getMessageConverter().toMessage(dto, messageProperties);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, dto);
        log.info("Отправлено на обработку из answering-service:{}", dto);
    }
}
