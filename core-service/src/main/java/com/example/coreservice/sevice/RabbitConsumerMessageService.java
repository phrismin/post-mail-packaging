package com.example.coreservice.sevice;

import com.example.coreservice.domain.MessageDto;

public interface RabbitConsumerMessageService {
    void processMessage(MessageDto messageDto);
}
