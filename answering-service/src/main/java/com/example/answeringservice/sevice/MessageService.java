package com.example.answeringservice.sevice;

import com.example.answeringservice.domain.MessageAndMessageDetailDto;
import org.springframework.http.ResponseEntity;

public interface MessageService {
    MessageAndMessageDetailDto findAnswerByUniqueMessage(String uniqueMessage);
}
