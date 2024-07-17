package com.example.answeringservice.repository;

import com.example.answeringservice.domain.MessageAndMessageDetailDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MessageRepository {
    MessageAndMessageDetailDto findAnswerByUniqueMessage(String uniqueMessage);
}
