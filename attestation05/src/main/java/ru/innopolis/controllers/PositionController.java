package ru.innopolis.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.models.DTO.request.PositionDTO;
import ru.innopolis.models.DTO.response.PositionResponseDTO;
import ru.innopolis.services.PositionServiceInterface;

@Slf4j
@RestController
@RequestMapping("/api/v1/position")
public class PositionController {

    @Autowired
    private PositionServiceInterface position;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PositionResponseDTO> create(@RequestBody PositionDTO dto){
        PositionResponseDTO response = position.create(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PositionResponseDTO> delete(@RequestBody PositionDTO dto){
        PositionResponseDTO response = position.delete(dto);
        return ResponseEntity.ok(response);
    }
}
