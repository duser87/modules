package ru.innopolis.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRegisterDataResponse {
    private Long idStudent;
    private String username;
    private String password;
    private String role;
}
