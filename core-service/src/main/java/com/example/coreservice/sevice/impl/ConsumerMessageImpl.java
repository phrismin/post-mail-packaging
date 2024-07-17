package com.example.coreservice.sevice.impl;

import com.example.coreservice.domain.MessageDto;
import com.example.coreservice.sevice.ConsumerMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerMessageImpl implements ConsumerMessageService {
    @Override
    @RabbitListener(queues = "message.process")
    public void processMessage(MessageDto messageDto) {
        log.info("Получено на обработку в core-service:{}", messageDto.toString());
    }
    //updateStatus, dto лучше(uniqueMessage, status)
}
