package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.EmployeeDTO;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;
import org.attestation_final.services.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/services/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employee;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> update(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> delete(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.delete(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> find(@PathVariable("id") Long id){
        EmployeeResponseDTO response = employee.findById(id);
        return ResponseEntity.ok(response);
    }

}
