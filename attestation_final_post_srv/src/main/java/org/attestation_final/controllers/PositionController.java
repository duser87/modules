package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PositionDTO;
import org.attestation_final.model.DTO.response.PositionResponseDTO;
import org.attestation_final.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/services/position")
public class PositionController {

    @Autowired
    private IPositionService position;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PositionResponseDTO> create(@RequestBody PositionDTO dto){
        PositionResponseDTO response = position.create(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PositionResponseDTO> delete(@PathVariable("id") Long id){
        PositionResponseDTO response = position.delete(id);
        return ResponseEntity.ok(response);
    }
}
