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

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaProducerService.sendMessage(message);
        return "-----> Message sent successfully";
    }
}
