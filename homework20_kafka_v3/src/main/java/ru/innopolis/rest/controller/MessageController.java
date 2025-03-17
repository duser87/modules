package ru.innopolis.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.dto.KafkaMessage;
import ru.innopolis.service.producer.KafkaJsonProducer;
import ru.innopolis.service.producer.KafkaProducer;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String str){
        kafkaProducer.sendMessage(str);
        return ResponseEntity.ok("<<<>>> Сообщение принято!");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody KafkaMessage message){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("<<<>>> Сообщение в формате JSON принято!");
    }
}
