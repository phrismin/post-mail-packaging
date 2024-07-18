package com.example.smtpservice.service;

public interface RabbitConsumerMessageService {
    void processMessage(String messageDto);
}
