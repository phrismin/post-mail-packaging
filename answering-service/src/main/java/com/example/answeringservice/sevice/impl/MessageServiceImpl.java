package com.example.answeringservice.sevice.impl;

import com.example.answeringservice.domain.MessageAndMessageDetailDto;
import com.example.answeringservice.repository.MessageRepository;
import com.example.answeringservice.sevice.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    @Transactional(readOnly = true)
    public MessageAndMessageDetailDto findAnswerByUniqueMessage(String uniqueMessage) {
        if (uniqueMessage == null || uniqueMessage.isBlank()) {

        }

        return messageRepository.findAnswerByUniqueMessage(uniqueMessage);
    }
}
