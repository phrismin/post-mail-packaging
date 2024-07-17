package com.example.answeringservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class MessageAndMessageDetailDto {

    private MessageDto message;

    private String errors;

    @JsonProperty("message_text")
    private String messageText;

    private String date;

    private String status;

    @JsonProperty("date_status")
    private String dateStatus;
}
