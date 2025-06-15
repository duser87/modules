package ru.innopolis.models.DTO.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PostResponseDTO implements Serializable {
    private Long id;
    private Long idEmpl;
    private Long idPos;
    private String message;
}
