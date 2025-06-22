package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.models.DTO.request.PatientDTO;
import org.attestation_final.models.DTO.request.PostDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.attestation_final.models.DTO.response.PostResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/main/post")
public class PostController {

    @Autowired
    private IMethodsCRUDService<PostResponseDTO, PostDTO> postService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> create(@RequestBody PostDTO dto){
        PostResponseDTO response = postService.create(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> delete(@PathVariable("id") Long id){
        PostResponseDTO response = postService.delete(id);
        return ResponseEntity.ok(response);
    }
}
