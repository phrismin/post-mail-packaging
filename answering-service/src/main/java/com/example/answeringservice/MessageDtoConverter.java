package com.example.answeringservice;

import com.example.answeringservice.domain.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

public class MessageDtoConverter implements MessageConverter {

    private final ObjectMapper objectMapper;

    public MessageDtoConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        try {
            if (object instanceof MessageDto) {
                String json = objectMapper.writeValueAsString(object);
                return new Message(json.getBytes(), messageProperties);
            }
            throw new MessageConversionException("MessageDtoConverter поддерживает только type");
        } catch (Exception e) {
            throw new MessageConversionException("Ошибка конвертации MessageDto в JSON", e);
        }
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        try {
            String json = new String(message.getBody());
            return objectMapper.readValue(json, MessageDto.class);
        } catch (Exception e) {
            throw new MessageConversionException("Ошибка конвертации JSON в MessageDto", e);
        }
    }
}