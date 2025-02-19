package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EarthquakeResponse {
    private Long id;
    private String title;
    private LocalDateTime time;
    private Double mag;
    private String place;
}
