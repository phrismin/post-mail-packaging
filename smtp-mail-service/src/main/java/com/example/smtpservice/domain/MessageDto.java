package com.example.smtpservice.domain;

import com.example.smtpservice.util.TypeFile;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Data
public class MessageDto {

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
    @JsonProperty("type_file")
    //TODO сделать и down
    private TypeFile typeFile;

    @NotNull
    private Map<String, String> data;
}
