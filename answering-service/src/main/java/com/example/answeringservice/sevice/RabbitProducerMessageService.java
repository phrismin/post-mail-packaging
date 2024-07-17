package com.example.answeringservice.sevice;

import com.example.answeringservice.domain.MessageDto;

public interface RabbitProducerMessageService {

    void sendMessage(MessageDto dto);
}
