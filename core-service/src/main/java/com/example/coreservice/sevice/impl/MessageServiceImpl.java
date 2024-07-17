package com.example.coreservice.sevice.impl;

import com.example.coreservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageRepository {

    private final MessageRepository messageRepository;
    @Override
    public String findTemplateById(Integer id) {
        return messageRepository.findTemplateById(id);
    }
}
