package ru.baranov.kafkamessagestub.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.baranov.kafkamessagestub.dto.KafkaMessage;
import ru.baranov.kafkamessagestub.dto.Message;
import ru.baranov.kafkamessagestub.repo.MessageRepository;

import java.util.Collections;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final ObjectMapper objectMapper;
    private static final String topic = "${app.kafka.topic}";
    private static final String groupId = "${spring.kafka.consumer.group-id}";
    private final MessageRepository repository;

    @KafkaListener(topics = topic, groupId = groupId)
    public void getKafkaMessage(KafkaMessage kafkaMessage) {
       Message message = Message.builder()
               .msgId(kafkaMessage.getMsgId())
               .timestamp(kafkaMessage.getTimestamp())
               .uri(kafkaMessage.getUri())
               .method(kafkaMessage.getMethod())
               .build();
       repository.save(message);
    }
}
