package org.attestation_final.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppointmentService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public
}
