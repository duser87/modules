package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/main/appointment")
public class AppointmentController {

    @Autowired
    private IMethodsCRUDService<AppointmentResponseDTO, AppointmentDTO> appointmentService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> create(@RequestBody AppointmentDTO dto){
        AppointmentResponseDTO response = appointmentService.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> update(@RequestBody AppointmentDTO dto){
        AppointmentResponseDTO response = appointmentService.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> delete(@PathVariable("id") Long id){
        AppointmentResponseDTO response = appointmentService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> find(@PathVariable("id") Long id){
        AppointmentResponseDTO response = appointmentService.find(id);
        return ResponseEntity.ok(response);
    }

}
