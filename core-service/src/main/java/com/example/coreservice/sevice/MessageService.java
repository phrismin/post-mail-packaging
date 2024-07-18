package com.example.coreservice.sevice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageService {
    String findTemplateById(Integer id);
}
