package ru.baranov.kafkamessagestub.dto;

import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public static Message toMessage(KafkaMessage kafkaMessage) {
        return Message.builder()
                .msgId(kafkaMessage.getMsgId())
                .timestamp(kafkaMessage.getTimestamp())
                .uri(kafkaMessage.getUri())
                .method(kafkaMessage.getMethod())
                .build();
    }
}
