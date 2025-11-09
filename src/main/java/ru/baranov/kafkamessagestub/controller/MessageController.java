package ru.baranov.kafkamessagestub.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.baranov.kafkamessagestub.dto.KafkaMessage;
import ru.baranov.kafkamessagestub.dto.MessageRequest;
import ru.baranov.kafkamessagestub.service.KafkaProducerService;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/post-message")
    public ResponseEntity<String> postMessage(@RequestBody @Valid MessageRequest messageRequest, HttpServletRequest request) {
        KafkaMessage kafkaMessage = KafkaMessage.builder()
                .msgId(messageRequest.getMsgId())
                .uri(request.getRequestURI())
                .method(request.getMethod())
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .build();
        try {
            kafkaProducerService.sendMessage(kafkaMessage);
            return ResponseEntity.ok("200 OK");
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send to Kafka" + e.getMessage());
        }
    }
}
