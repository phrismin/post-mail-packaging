package com.example.coreservice.repository.impl;

import com.example.coreservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MessageRepositoryImpl implements MessageRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public String findTemplateById(Integer id) {
        return jdbcTemplate.queryForObject("select template from templates where id = ?", String.class, id);
    }
}
