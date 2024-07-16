package com.example.coreservice.sevice.impl;

import com.example.answeringservice.domain.MessageAndMessageDetailDto;
import com.example.answeringservice.repository.MessageRepository;
import com.example.coreservice.sevice.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findAnswerByUniqueMessage(String uniqueMessage) {
        if (uniqueMessage == null || uniqueMessage.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        MessageAndMessageDetailDto result = messageRepository.findAnswerByUniqueMessage(uniqueMessage);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
