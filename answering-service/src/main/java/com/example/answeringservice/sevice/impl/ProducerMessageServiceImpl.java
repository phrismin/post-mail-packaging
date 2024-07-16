package com.example.answeringservice.sevice.impl;

import com.example.answeringservice.domain.MessageDto;
import com.example.answeringservice.sevice.ProducerMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerMessageServiceImpl implements ProducerMessageService {
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public ResponseEntity<?> sendMessage(MessageDto dto) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, dto);
        log.info("Отправлено на обработку из answering-service:" + dto.toString());
        return ResponseEntity
                .ok()
                .body(dto);
    }
}
