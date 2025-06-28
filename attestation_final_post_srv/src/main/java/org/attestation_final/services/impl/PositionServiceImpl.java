package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PositionDTO;
import org.attestation_final.model.DTO.response.PositionResponseDTO;
import org.attestation_final.model.entities.PositionEntity;
import org.attestation_final.repositories.JpaPositionRepository;
import org.attestation_final.services.IPositionService;
import org.springframework.stereotype.Service;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PositionServiceImpl implements IPositionService {

    private final JpaPositionRepository jpaPositionRepository;


    /**
     * Метод добавления новой записи о должности в БД
     * @param dto - объект класса PositionDTO
     * @return информация о успешном создании записи о новой должности. Тип - PositionResponseDTO
     */
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

    /**
     * Метод получения записи о должности из БД по id
     * @param id - идентификатор
     * @return объект PositionResponseDTO, содержащий информацию о получении записи из БД
     */
    @Override
    public PositionResponseDTO delete(Long id) {
        PositionEntity result = new PositionEntity();
        String msg = "";
        try{
            result = jpaPositionRepository.findById(id).orElseThrow();
            jpaPositionRepository.deleteById(id);
            msg = " -> Должность удалена";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PositionResponseDTO.builder()
                .position(result.getPosition())
                .message(msg)
                .build();
    }
}
