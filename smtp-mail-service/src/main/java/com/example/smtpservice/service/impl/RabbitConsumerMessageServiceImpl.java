package com.example.smtpservice.service.impl;

import com.example.smtpservice.domain.MessageDto;
import com.example.smtpservice.service.RabbitConsumerMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitConsumerMessageServiceImpl implements RabbitConsumerMessageService {

    @Override
    @RabbitListener(queues = "message.send")
    public void processMessage(MessageDto messageDto) {
        log.info("Получено на обработку в smtp-mail-service:{}", messageDto.toString());
    }
}
