package com.example.answeringservice.repository;

import com.example.answeringservice.domain.MessageDetailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageRepository {
    MessageDetailDto findAnswerByUniqueMessage(String uniqueMessage);
}
