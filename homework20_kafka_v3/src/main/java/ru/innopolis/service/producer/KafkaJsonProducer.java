package ru.innopolis.service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.KafkaMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public void sendMessage(KafkaMessage message){
        Message<KafkaMessage> msg = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, "test-6")
                .build();
        log.info(String.format("--->>> Отправка сообщения в топик test-6: %s", message));
        kafkaTemplate.send(msg);
    }
}
