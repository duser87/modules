package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoResponse {
    private Long id;
    private String name;
    private LocalDate dateStart;
    private Boolean archive;
    private String msg;
}
