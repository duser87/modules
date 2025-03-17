package ru.innopolis.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class KafkaMessage {
    private Long id;
    private String message;
}
