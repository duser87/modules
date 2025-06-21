package org.attestation_final.services.impl;

import org.attestation_final.services.IKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer implements IKafkaProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String str){
        kafkaTemplate.send("appointment-topic", str);
    }

}
