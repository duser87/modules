package ru.innopolis.services;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ru.innopolis.models.ChatMessage;
import ru.innopolis.models.Message;
import ru.innopolis.repositories.ChatMessageRepository;

@Service
public class ChatService {
    private final SimpMessagingTemplate messagingTemplate;

    public ChatService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(Message message) {
        messagingTemplate.convertAndSend("/topic/messages", message); // Отправка сообщения всем подписанным клиентам
    }
}
