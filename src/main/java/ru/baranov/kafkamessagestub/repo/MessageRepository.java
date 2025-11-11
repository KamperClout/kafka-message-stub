package ru.baranov.kafkamessagestub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.baranov.kafkamessagestub.dto.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
