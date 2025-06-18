package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.AppointmentDTO;
import org.attestation_final.model.DTO.response.AppointmentResponseDTO;
import org.attestation_final.services.AppointmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/services/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceInterface appointment;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> create(@RequestBody AppointmentDTO dto){
        AppointmentResponseDTO response = appointment.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> update(@RequestBody AppointmentDTO dto){
        AppointmentResponseDTO response = appointment.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> delete(@RequestBody AppointmentDTO dto){
        AppointmentResponseDTO response = appointment.delete(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> find(@PathVariable("id") Long id){
        AppointmentResponseDTO response = appointment.findById(id);
        return ResponseEntity.ok(response);
    }

}