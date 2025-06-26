package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Это класс, описывающий объект ответа от сервиса работников (EmployeeService) больницы. Он имеет следующие поля:
 * - id - идентификатор в БД
 * - fio - Ф.И.О работника, тип поля String
 * - tel - номер телефона работника, тип поля String
 * - message - Информационное сообщение клиентской стороне
 */
@Data
@Builder
@RedisHash("employee-data")
public class EmployeeResponseDTO implements Serializable {
    private Long id;
    private String fio;
    private String tel;
    private String message;
}