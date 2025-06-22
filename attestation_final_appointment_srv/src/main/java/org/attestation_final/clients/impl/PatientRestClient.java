package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.model.DTO.response.PatientResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PatientRestClient implements IMethodsCRUDRest<PatientResponseDTO> {

    RestClient restClient;
    private static final String URL = "http://localhost:8083/api/v1/services/patient";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public PatientResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(PatientResponseDTO.class);
    }
}
