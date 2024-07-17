package com.example.answeringservice.sevice;

import com.example.answeringservice.domain.MessageExtendDto;

public interface MessageService {
    MessageExtendDto findAnswerByUniqueMessage(String uniqueMessage);
}
