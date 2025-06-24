package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа от сервиса работников (EmployeeService) больницы. Он имеет следующие поля:
 * - id - идентификатор в БД
 * - fio - Ф.И.О работника, тип поля String
 * - tel - номер телефона работника, тип поля String
 * - message - Информационное сообщение клиентской стороне
 */
@Data
@Builder
public class EmployeeResponseDTO{
    private Long id;
    private String fio;
    private String tel;
    private String message;
}