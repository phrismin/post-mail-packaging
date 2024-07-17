package com.example.answeringservice.controller;

import com.example.answeringservice.domain.MessageAndMessageDetailDto;
import com.example.answeringservice.domain.MessageDto;
import com.example.answeringservice.sevice.MessageService;
import com.example.answeringservice.sevice.ProducerMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MessageController {

    private final ProducerMessageService producerMessageService;
    private final MessageService messageService;

    //TODO AdviceController
    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody MessageDto dto, BindingResult bindingResult) {
        producerMessageService.sendMessage(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/answer/{UniqueMessage}")
    public ResponseEntity<?> getAnswerByUniqueMessage(@PathVariable("UniqueMessage") String uniqueMessage) {
        MessageAndMessageDetailDto answerByUniqueMessage = messageService.findAnswerByUniqueMessage(uniqueMessage);
        return ResponseEntity.ok().body(answerByUniqueMessage);
    }
}
