package ru.innopolis.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.KafkaMessage;
import ru.innopolis.service.KafkaProducerService;

@RestController
public class KafkaController {
    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@RequestBody KafkaMessage message) {
        kafkaProducerService.sendMessage(message.getMessage());
        return "-----> Message sent successfully";
    }
}
