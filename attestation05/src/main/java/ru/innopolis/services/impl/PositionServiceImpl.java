package ru.innopolis.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.models.DTO.request.PositionDTO;
import ru.innopolis.models.DTO.response.PositionResponseDTO;
import ru.innopolis.models.Entity.PositionEntity;
import ru.innopolis.repositories.JpaPositionRepository;
import ru.innopolis.services.PositionServiceInterface;

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
