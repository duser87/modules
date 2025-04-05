package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentsDTO {
    private Long id;
    private String fioDoc;
    private String fioPac;
    private String time;
    private String description;
}
