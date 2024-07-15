package com.example.answeringservice.sevice;

import org.springframework.http.ResponseEntity;

public interface MessageService {
    ResponseEntity<?> findAnswerByUniqueMessage(String uniqueMessage);
}
