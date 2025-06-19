package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PatientDTO;
import org.attestation_final.model.DTO.response.PatientResponseDTO;
import org.attestation_final.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/services/patient")
public class PatientController {

    @Autowired
    private IPatientService patient;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientDTO dto){
        PatientResponseDTO response = patient.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> update(@RequestBody PatientDTO dto){
        PatientResponseDTO response = patient.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> delete(@RequestBody PatientDTO dto){
        PatientResponseDTO response = patient.delete(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> find(@PathVariable("id") Long id){
        PatientResponseDTO response = patient.findById(id);
        return ResponseEntity.ok(response);
    }

}