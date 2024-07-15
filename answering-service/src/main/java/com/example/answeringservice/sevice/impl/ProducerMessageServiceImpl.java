package com.example.answeringservice.sevice.impl;

import com.example.answeringservice.domain.MessageDto;
import com.example.answeringservice.sevice.ProducerMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerMessageServiceImpl implements ProducerMessageService {
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public ResponseEntity<?> sendMessage(MessageDto dto) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, dto);
        return ResponseEntity
                .ok()
                .body(dto);
    }
}
