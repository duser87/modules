package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class EmployeeRESTClient implements IMethodsCRUDRest<EmployeeResponseDTO> {

    RestClient restClient;
    private static final String URL = "http://localhost:8082/api/v1/services/employee";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public EmployeeResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }
}
