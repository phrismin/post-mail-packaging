package com.example.smtpservice.service;

import com.example.smtpservice.domain.MessageDto;

public interface RabbitConsumerMessageService {
    void processMessage(MessageDto messageDto);
}
