package com.example.coreservice.sevice;

import com.example.answeringservice.domain.MessageDto;

public interface ConsumerMessageService {
    void consumeMessage(MessageDto messageDto);
}
