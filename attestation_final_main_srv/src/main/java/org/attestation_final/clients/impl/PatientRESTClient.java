package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.PatientDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PatientRESTClient implements IMethodsCRUDRest<PatientResponseDTO, PatientDTO> {
    RestClient restClient;
    private static final String URL = "http://localhost:8083/api/v1/services/patient";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public PatientResponseDTO createREST(PatientDTO dto) {
        return restClient.post()
                .uri(URL + "/create")
                .body(dto)
                .retrieve()
                .body(PatientResponseDTO.class);
    }

    @Override
    public PatientResponseDTO updateREST(PatientDTO dto) {
        return restClient.put()
                .uri(URL + "/update")
                .body(dto)
                .retrieve()
                .body(PatientResponseDTO.class);
    }

    @Override
    public PatientResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/delete/{id}", id)
                .retrieve()
                .body(PatientResponseDTO.class);
    }

    @Override
    public PatientResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(PatientResponseDTO.class);
    }
}
