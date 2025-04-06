package ru.innopolis.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.AppointmentsDTO;
import ru.innopolis.service.AppointmentService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentsController {

    private final AppointmentService appointmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addAppointment(@Valid @RequestBody AppointmentsDTO dto){
        log.info(dto.toString());
        var result = appointmentService.create(dto);
        log.info(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentsDTO> findByIdAppointment(@PathVariable("id") Long id){
        var result = appointmentService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAppointment(@Valid @RequestBody AppointmentsDTO dto){
        var result = appointmentService.update(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long id){
        String noteResponse = appointmentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
