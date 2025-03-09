package ru.innopolis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private String room;
    private String sender;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
