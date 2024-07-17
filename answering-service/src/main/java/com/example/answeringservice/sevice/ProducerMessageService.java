package com.example.answeringservice.sevice;

import com.example.answeringservice.domain.MessageDto;
import org.springframework.http.ResponseEntity;

public interface ProducerMessageService {

    void sendMessage(MessageDto dto);
}
