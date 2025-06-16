package ru.innopolis.models.DTO.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
public class AppointmentResponseDTO implements Serializable {
    private Long id;
    private Long idEmpl;
    private Long idPat;
    private String time;
    private String description;
    private String message;
}
