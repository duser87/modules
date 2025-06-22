package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AppointmentRESTClient implements IMethodsCRUDRest<AppointmentResponseDTO, AppointmentDTO> {

    RestClient restClient;
    private static final String URL = "http://localhost:8081/api/v1/services/appointment";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public AppointmentResponseDTO createREST(AppointmentDTO dto) {
        return restClient.post()
                .uri(URL + "/create")
                .body(dto)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }

    @Override
    public AppointmentResponseDTO updateREST(AppointmentDTO dto) {
        return restClient.put()
                .uri(URL + "/update")
                .body(dto)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }

    @Override
    public AppointmentResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/delete/{id}", id)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }

    @Override
    public AppointmentResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }
}
