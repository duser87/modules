package ru.innopolis.models.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponseDTO {
    private Long id;
    private String fio;
    private String tel;
    private String message;
}
