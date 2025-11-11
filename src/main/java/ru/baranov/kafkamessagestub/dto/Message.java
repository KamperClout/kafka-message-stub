package ru.baranov.kafkamessagestub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "msg_id", nullable = false)
    String msgId;
    @Column(name = "timestamp", nullable = false)
    String timestamp;
    @Column(name = "uri", nullable = false)
    String uri;
    @Column(name = "method", nullable = false)
    String method;
}
