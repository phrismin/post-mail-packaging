package com.example.coreservice.sevice;

import org.springframework.http.ResponseEntity;

public interface MessageService {
    ResponseEntity<?> findAnswerByUniqueMessage(String uniqueMessage);
}
