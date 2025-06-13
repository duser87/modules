package ru.innopolis.models.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponseDTO {
    private Long id;
    private Long idEmpl;
    private Long idPos;
    private String message;
}
