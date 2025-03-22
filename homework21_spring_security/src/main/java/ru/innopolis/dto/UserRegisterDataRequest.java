package ru.innopolis.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRegisterDataRequest {
    private String username;
    private String password;
}
