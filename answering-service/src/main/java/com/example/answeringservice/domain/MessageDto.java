package com.example.answeringservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Data
@Accessors(chain = true)
public class MessageDto implements Serializable {
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
}
