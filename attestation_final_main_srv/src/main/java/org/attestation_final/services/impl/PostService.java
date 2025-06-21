package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.PostDTO;
import org.attestation_final.models.DTO.response.PostResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService implements IMethodsCRUDService<PostResponseDTO, PostDTO> {

    private  final IMethodsCRUDRest<PostResponseDTO, PostDTO> restClient;

    @Override
    public PostResponseDTO create(PostDTO dto) {
        return restClient.createREST(dto);
    }

    @Override
    public PostResponseDTO update(PostDTO dto) {
        return restClient.updateREST(dto);
    }

    @Override
    public PostResponseDTO delete(Long id) {
        return restClient.deleteREST(id);
    }

    @Override
    public PostResponseDTO find(Long id) {
        return restClient.findREST(id);
    }
}
