package com.example.answeringservice.sevice.impl;

import com.example.answeringservice.domain.MessageExtendDto;
import com.example.answeringservice.repository.MessageRepository;
import com.example.answeringservice.sevice.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    @Transactional(readOnly = true)
    public MessageExtendDto findAnswerByUniqueMessage(String uniqueMessage) {
        if (uniqueMessage == null || uniqueMessage.isBlank()) {
            //TODO выбросить исключение
        }
        return messageRepository.findAnswerByUniqueMessage(uniqueMessage);
    }
}
