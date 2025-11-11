package ru.baranov.kafkamessagestub.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.baranov.kafkamessagestub.dto.KafkaMessage;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final ObjectMapper objectMapper;
    @Value("${app.kafka.topic}")
    private String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(KafkaMessage kafkaMessage) {
        try {
            String message = objectMapper.writeValueAsString(kafkaMessage);
            kafkaTemplate.send(topic, kafkaMessage.getMsgId(), message).get(5, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            throw new RuntimeException("Unable to send message");
        }
    }
}
