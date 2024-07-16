package com.example.answeringservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.util.Map;

@Data
@Accessors(chain = true)
public class MessageDetailDto {
//    private MessageDto message;
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @JsonProperty("unique_message")
    private String uniqueMessage;

    @NotNull
    @JsonProperty("group_users")
    private Integer groupUsers;

    @NotNull
    @JsonProperty("template_id")
    private Integer templateId;

    @NotNull
    private String file;

    @NotNull
    @NotBlank
    @JsonProperty("type_file")
    private String typeFile;

    @NotNull
    private Map<String, String> data;

    private String errors;

    @JsonProperty("message_text")
    private String messageText;

    private String date;

    private String status;

    @JsonProperty("date_status")
    private String dateStatus;
}
