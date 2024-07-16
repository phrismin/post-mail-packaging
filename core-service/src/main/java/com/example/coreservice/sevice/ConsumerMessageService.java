package com.example.coreservice.sevice;

import com.example.coreservice.domain.MessageDto;

public interface ConsumerMessageService {
    void consumeMessage(MessageDto messageDto);
}
