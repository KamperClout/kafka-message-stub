package ru.baranov.kafkamessagestub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    @NotBlank(message = "не может быть пустым")
    @Pattern(regexp = "[A-Za-z0-9]{3,12}", message = "msg_id должен содержать только цифры и/или буквы от 3 до 12 симв")
    @JsonProperty("msg_id")
    private String msgId;
}
