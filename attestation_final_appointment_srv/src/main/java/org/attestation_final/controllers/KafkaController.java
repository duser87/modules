package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.AppointmentDTO;
import org.attestation_final.services.impl.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/services/topic/appointment")
public class KafkaController {

    @Autowired
    KafkaProducer service;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendMessage(@RequestBody AppointmentDTO dto){
        service.sendMessage(dto.getDescription());
        return ResponseEntity.ok(" --> OK!");
    }
}
