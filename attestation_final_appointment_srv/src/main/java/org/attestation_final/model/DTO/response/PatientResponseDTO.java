package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа от сервиса клиентов (PatientService) больницы. Он имеет следующие поля:
 * - id - идентификатор в БД
 * - fio - Ф.И.О клиента
 * - tel - номер телефона клиента
 * - address - адрес проживания клиента
 */
@Data
@Builder
public class PatientResponseDTO {
    private Long id;
    private String fio;
    private String tel;
    private String address;

}
