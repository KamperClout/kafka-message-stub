package ru.baranov.kafkamessagestub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"msg_id", "timestamp", "uri", "method"})
public class KafkaMessage {
    @JsonProperty("msg_id")
    String msgId;
    @JsonProperty("timestamp")
    String timestamp;
    @JsonProperty("uri")
    String uri;
    @JsonProperty("method")
    String method;
}
