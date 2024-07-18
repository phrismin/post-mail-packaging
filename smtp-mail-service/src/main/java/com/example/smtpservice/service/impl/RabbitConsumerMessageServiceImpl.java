package com.example.smtpservice.service.impl;

import com.example.smtpservice.domain.MessageDto;
import com.example.smtpservice.service.MailSendingService;
import com.example.smtpservice.service.RabbitConsumerMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitConsumerMessageServiceImpl implements RabbitConsumerMessageService {

    private final MailSendingService mailSendingService;

    @Override
    @RabbitListener(queues = "mail.send")
    public void processMessage(String messageDto) {
        log.info("Получено на обработку в smtp-mail-service:{}", messageDto.toString());

        try {
            mailSendingService.send("success@simulator.amazonses.com", "Subject", "Text");
        } catch (Exception e) {
            //TODO
        }
    }
}
