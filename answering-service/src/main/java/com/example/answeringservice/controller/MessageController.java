package com.example.answeringservice.controller;

import com.example.answeringservice.domain.MessageExtendDto;
import com.example.answeringservice.domain.MessageDto;
import com.example.answeringservice.sevice.MessageService;
import com.example.answeringservice.sevice.RabbitProducerMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MessageController {

    private final RabbitProducerMessageService rabbitProducerMessageService;
    private final MessageService messageService;

    //TODO AdviceController
    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody MessageDto dto) {
        rabbitProducerMessageService.sendMessageToCoreService(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/answer/{uniqueMessage}")
    public ResponseEntity<?> getAnswerByUniqueMessage(@PathVariable String uniqueMessage) {
        MessageExtendDto answerByUniqueMessage = messageService.findAnswerByUniqueMessage(uniqueMessage);
        return ResponseEntity.ok().body(answerByUniqueMessage);
    }
}
