package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.ChatMessage;

@Repository
public interface JpaChatRepository extends JpaRepository<ChatMessage, Long> {
}
