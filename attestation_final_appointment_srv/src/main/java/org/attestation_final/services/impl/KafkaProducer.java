package org.attestation_final.services.impl;

import io.swagger.v3.oas.annotations.Operation;
import org.attestation_final.services.IKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Класс service-слоя. Реализующий отправку сообщения в топик Kafka, для передачи к другому сервису
 */
@Service
public class KafkaProducer implements IKafkaProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Метод реализует отправку сообщения в топик
     * @param str - сообщение, тип String
     *
     */
    @Operation(summary="Метод отправки сообщения в топик", description = "Отправка сообщения в топик")
    @Override
    public void sendMessage(String str){
        kafkaTemplate.send("appointment-topic", str);
    }

}
