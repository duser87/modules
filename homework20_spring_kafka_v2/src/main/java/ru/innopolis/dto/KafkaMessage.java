package ru.innopolis.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class KafkaMessage {
    @JsonProperty(value = "ID")
    private Long id;

    @JsonIgnore
    private String message;

    @JsonFormat
    private LocalDateTime sendTime;
}