package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import ru.innopolis.models.ChatMessage;
import ru.innopolis.models.Message;
import ru.innopolis.services.ChatService;

@Controller
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/send") // Указывает, что этот метод будет вызываться при получении сообщения на "/app/send"
    @SendTo("/topic/messages") // Указывает, что результат будет отправлен всем подписанным на "/topic/messages"
    public Message send(Message message) {
        chatService.sendMessage(message);
        return message; // Возвращает сообщение, которое будет отправлено всем клиентам
    }
}
