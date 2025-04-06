package ru.innopolis.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.AppointmentsDTO;
import ru.innopolis.dto.DoctorDTO;
import ru.innopolis.service.DoctorService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDoctor(@Valid @RequestBody DoctorDTO dto){
        log.info(dto.toString());
        var result = doctorService.create(dto);
        log.info(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDTO> findByIdDoctor(@PathVariable("id") Long id){
        var result = doctorService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDoctor(@Valid @RequestBody DoctorDTO dto){
        var result = doctorService.update(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long id){
        String noteResponse = doctorService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
