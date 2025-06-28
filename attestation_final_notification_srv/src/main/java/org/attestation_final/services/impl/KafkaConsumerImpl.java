package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.services.IKafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerImpl implements IKafkaConsumer {

    private final EmailServiceImpl emailService;

    @Override
    @KafkaListener(topics = "appointment-topic")
    public void consumeMessage(String str) {
        log.info(str);

        //emailService.send("duser87@yandex.ru", "Запись на прием", str);

    }
}
