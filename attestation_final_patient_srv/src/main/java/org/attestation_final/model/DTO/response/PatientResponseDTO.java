package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Это класс, описывающий объект ответа клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - fio - ФИО клиента, тип String
 * - tel - Номер телефона клиента, тип String
 * - address - адрес клиента, тип String
 * - message - информационное сообщение
 */
@Data
@Builder
@RedisHash("patient-data")
public class PatientResponseDTO implements Serializable {
    private Long id;
    private String fio;
    private String tel;
    private String address;
    private String message;
}