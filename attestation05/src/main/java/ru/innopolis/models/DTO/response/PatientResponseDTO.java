package ru.innopolis.models.DTO.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PatientResponseDTO implements Serializable {
    private Long id;
    private String fio;
    private String tel;
    private String address;
    private String message;
}
