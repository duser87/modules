package org.attestation_final.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.services.IKafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer implements IKafkaConsumer {
    @Override
    @KafkaListener(topics = "appointment-topic")
    public void consumeMessage(String str) {
        log.info(str);
    }
}
