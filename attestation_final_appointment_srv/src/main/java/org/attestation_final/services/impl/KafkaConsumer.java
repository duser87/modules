package org.attestation_final.services.impl;

import org.attestation_final.services.IKafkaConsumer;
import org.attestation_final.services.IKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class KafkaConsumer implements IKafkaConsumer {

    @Autowired
    IKafkaProducer producer;

    @Override
    @KafkaListener(topics = "post-topic")
    public void consumeMessage(String str) {
        System.out.println(URLDecoder.decode(str, StandardCharsets.UTF_8));
        producer.sendMessage(URLDecoder.decode(str, StandardCharsets.UTF_8));
    }
}
