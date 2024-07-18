package com.example.coreservice.repository.impl;

import com.example.coreservice.repository.MessageRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    @Override
    public String findTemplateById(Integer id) {
        return null;
    }
}
