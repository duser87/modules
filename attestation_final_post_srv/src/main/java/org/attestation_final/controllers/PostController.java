package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PostDTO;
import org.attestation_final.model.DTO.response.PostResponseDTO;
import org.attestation_final.services.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostServiceInterface post;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> create(@RequestBody PostDTO dto){
        PostResponseDTO response = post.create(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> delete(@RequestBody PostDTO dto){
        PostResponseDTO response = post.delete(dto);
        return ResponseEntity.ok(response);
    }
}
