package com.example.coreservice.sevice.impl;

import com.example.coreservice.repository.MessageRepository;
import com.example.coreservice.sevice.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    @Override
    public String findTemplateById(Integer id) {
        return messageRepository.findTemplateById(id);
    }
}
