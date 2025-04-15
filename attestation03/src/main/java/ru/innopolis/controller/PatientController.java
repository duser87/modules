package ru.innopolis.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.PatientEntity;
import ru.innopolis.service.PatientService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDoctor(@Valid @RequestBody PatientEntity pe){
        log.info(pe.toString());
        var result = patientService.create(pe);
        log.info(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientEntity> findByIdDoctor(@PathVariable("id") Long id){
        var result = patientService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDoctor(@Valid @RequestBody PatientEntity pe){
        var result = patientService.update(pe);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long id){
        String noteResponse = patientService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
