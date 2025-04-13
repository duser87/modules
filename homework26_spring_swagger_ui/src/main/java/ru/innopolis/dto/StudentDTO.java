package ru.innopolis.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, отражающий сущность в БД. Он имеет следующие поля:
 *  -идентификатор студента
 *  - fio-Ф.И.О. студента
 *  - email-электронный адрес студента
 *  - age-возраст
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Schema(description = "Представляет пользователя в приложении")
public class StudentDTO {
    private String fio;
    private String email;
    private Integer age;
}
