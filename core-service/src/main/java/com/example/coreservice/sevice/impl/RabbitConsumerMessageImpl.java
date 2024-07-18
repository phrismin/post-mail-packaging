package com.example.coreservice.sevice.impl;

import com.example.coreservice.domain.MessageDto;
import com.example.coreservice.repository.MessageRepository;
import com.example.coreservice.sevice.MessageService;
import com.example.coreservice.sevice.RabbitConsumerMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitConsumerMessageImpl implements RabbitConsumerMessageService {

    private final MessageService messageService;

    @Override
    @RabbitListener(queues = "message.process")
    public void processMessage(MessageDto messageDto) {
        log.info("Получено на обработку в core-service:{}", messageDto.toString());
        String template = messageService.findTemplateById(messageDto.getTemplateId());
//        Integer groupUsers = messageDto.getGroupUsers();

        sendMessageToSmtpService();
    }

    private void sendMessageToSmtpService() {
        log.info("Письмо отправлено на обработку в smtp-mail-service:{}");
    }


    //updateStatus, dto (uniqueMessage, status)
}
