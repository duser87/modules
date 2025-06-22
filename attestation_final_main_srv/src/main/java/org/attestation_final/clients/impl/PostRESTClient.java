package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.PostDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.attestation_final.models.DTO.response.PostResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PostRESTClient implements IMethodsCRUDRest<PostResponseDTO, PostDTO> {
    RestClient restClient;
    private static final String URL = "http://localhost:8084/api/v1/services/post";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public PostResponseDTO createREST(PostDTO dto) {
        return restClient.post()
                .uri(URL + "/create")
                .body(dto)
                .retrieve()
                .body(PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO updateREST(PostDTO dto) {
        return restClient.put()
                .uri(URL + "/update")
                .body(dto)
                .retrieve()
                .body(PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/delete/{id}", id)
                .retrieve()
                .body(PostResponseDTO.class);
    }

    @Override
    public PostResponseDTO findREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(PostResponseDTO.class);
    }
}
