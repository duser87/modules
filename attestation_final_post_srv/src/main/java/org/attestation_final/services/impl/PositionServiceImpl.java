package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PositionDTO;
import org.attestation_final.model.DTO.response.PositionResponseDTO;
import org.attestation_final.model.entities.PositionEntity;
import org.attestation_final.repositories.JpaPositionRepository;
import org.attestation_final.services.PositionServiceInterface;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionServiceInterface {

    private final JpaPositionRepository jpaPositionRepository;


    @Override
    public PositionResponseDTO create(PositionDTO dto) {
        PositionEntity result = new PositionEntity();
        try{
            result = jpaPositionRepository.save(PositionEntity.builder()
                    .position(dto.getDescription())
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PositionResponseDTO.builder()
                .id(result.getId())
                .position(result.getPosition())
                .message(" -> Должность добавлена!")
                .build();
    }

    @Override
    public PositionResponseDTO delete(PositionDTO dto) {
        PositionEntity result = new PositionEntity();
        String msg = "";
        try{
            jpaPositionRepository.deleteByPosition(dto.getDescription());
            msg = " -> Должность удалена";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PositionResponseDTO.builder()
                .position(dto.getDescription())
                .message(msg)
                .build();
    }
}
