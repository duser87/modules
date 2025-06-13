package ru.innopolis.services;

import ru.innopolis.models.DTO.request.PositionDTO;
import ru.innopolis.models.DTO.request.PostDTO;
import ru.innopolis.models.DTO.response.PostResponseDTO;

public interface PostServiceInterface {
    PostResponseDTO create(PostDTO dto);
    PostResponseDTO delete(PostDTO dto);
}
