package org.attestation_final.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListeners {
    @KafkaListener(topics = "employee_srv", groupId = "clinic")
    public void listener(String str){
        System.out.println("---> Слушатель получил:" + str);
    }
}
