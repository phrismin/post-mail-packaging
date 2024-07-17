package com.example.coreservice.sevice.impl;

import com.example.coreservice.domain.MessageDto;
import com.example.coreservice.repository.MessageRepository;
import com.example.coreservice.sevice.RabbitConsumerMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerMessageImpl implements RabbitConsumerMessageService {

    private final MessageRepository messageRepository;

    @Override
    @RabbitListener(queues = "message.process")
    public void processMessage(MessageDto messageDto) {
        log.info("Получено на обработку в core-service:{}", messageDto.toString());

    }
    //updateStatus, dto лучше(uniqueMessage, status)
}
