package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.EmployeeDTO;
import org.attestation_final.models.DTO.response.EmployeeResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class EmployeeRESTClient implements IMethodsCRUDRest<EmployeeResponseDTO, EmployeeDTO> {

    RestClient restClient;
    private static final String URL = "http://localhost:8082/api/v1/services/employee";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public EmployeeResponseDTO createREST(EmployeeDTO dto) {
        return restClient.post()
                .uri(URL + "/create")
                .body(dto)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }

    @Override
    public EmployeeResponseDTO updateREST(EmployeeDTO dto) {
        return restClient.put()
                .uri(URL + "/update")
                .body(dto)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }

    @Override
    public EmployeeResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/delete/{id}", id)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }

    @Override
    public EmployeeResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }
}
