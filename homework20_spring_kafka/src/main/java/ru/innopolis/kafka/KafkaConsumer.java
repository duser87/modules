package ru.innopolis.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;
import ru.innopolis.dto.KafkaMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ReactiveKafkaConsumerTemplate<String, KafkaMessage> reactiveKafkaConsumerTemplate;

    @KafkaListener(topics = "test-1", groupId = "group_id")
    public void listen(KafkaMessage message){
        log.info("message --> " + message);
    }
}
