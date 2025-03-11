package ru.innopolis.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import ru.innopolis.models.ChatMessage;
import ru.innopolis.models.MessageType;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String userName = (String) headerAccessor.getSessionAttributes().get("username");

        if(userName != null){
            log.info("--->>> Пользователь отключился: " + userName + " " + LocalDateTime.now());
            var chatMessage = ChatMessage.builder()
                    //.type(MessageType.LEAVE)
                    .sender(userName)
                    .build();
            messageTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
