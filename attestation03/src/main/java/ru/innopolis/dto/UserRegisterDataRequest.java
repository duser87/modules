package ru.innopolis.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDataRequest {
    private Long idUsr;
    private String username;
    private String password;
    private String email;
}