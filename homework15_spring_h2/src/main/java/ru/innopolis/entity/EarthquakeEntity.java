package ru.innopolis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "earthquake")
@Builder
public class EarthquakeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private LocalDateTime time;
    private Double mag;
    private String place;
}
