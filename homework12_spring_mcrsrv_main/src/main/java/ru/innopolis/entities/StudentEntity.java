package ru.innopolis.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    private Long id;
    @NotNull
    @Size(min = 2, max = 100)
    private String fio;
    @NotNull
    @Email
    private String email;
}
