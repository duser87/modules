package ru.innopolis.services;

import ru.innopolis.models.DTO.request.PositionDTO;
import ru.innopolis.models.DTO.response.PositionResponseDTO;

public interface PositionServiceInterface {
    PositionResponseDTO create(PositionDTO dto);
    PositionResponseDTO delete(PositionDTO dto);
}
