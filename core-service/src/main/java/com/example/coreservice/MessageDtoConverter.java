package com.example.coreservice;

import com.example.coreservice.domain.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Component;

@Component
public class MessageDtoConverter implements MessageConverter {

    private final ObjectMapper objectMapper;

    public MessageDtoConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @NonNull
    @Override
    public Message toMessage(@NonNull Object object, @NonNull MessageProperties messageProperties) throws MessageConversionException {
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

    @NonNull
    @Override
    public Object fromMessage(@NonNull Message message) throws MessageConversionException {
        try {
            String json = new String(message.getBody());
            return objectMapper.readValue(json, MessageDto.class);
        } catch (Exception e) {
            throw new MessageConversionException("Ошибка конвертации JSON в MessageDto", e);
        }
    }
}
