package com.example.answeringservice.repository;

import com.example.answeringservice.domain.MessageExtendDto;
import org.apache.ibatis.annotations.*;

public interface MessageRepository {
    MessageExtendDto findAnswerByUniqueMessage(String uniqueMessage);
}
