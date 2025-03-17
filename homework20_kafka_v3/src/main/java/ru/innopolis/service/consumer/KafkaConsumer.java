package ru.innopolis.service.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.KafkaMessage;

@Service
@Slf4j
public class KafkaConsumer {

//    Метод для сообщений с типом данных - String

//    @KafkaListener(topics = "test-2", groupId = "idGroupTest")
    public void consumMessage(String msg){
        log.info(String.format("<<<--- Принято сообщение из топика test-2: %s", msg));
    }

    @KafkaListener(topics = "test-6", groupId = "idGroupTest")
    public void consumJsonMessage(KafkaMessage msg){
        log.info(String.format("<<<--- Принято сообщение формата JSON из топика test-6: %s", msg.toString()));
    }
}
