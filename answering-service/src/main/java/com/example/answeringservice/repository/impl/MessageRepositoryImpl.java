package com.example.answeringservice.repository.impl;

import com.example.answeringservice.domain.MessageExtendDto;
import com.example.answeringservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MessageRepositoryImpl implements MessageRepository {
    @Override
    public MessageExtendDto findAnswerByUniqueMessage(String uniqueMessage) {
        return null;
    }
}
