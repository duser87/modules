package ru.innopolis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reviews", schema = "student")
public class ReviewEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "id_student")
    private Long id_student;

    @Column(name = "id_course")
    private Long id_course;

    @Column(name = "review")
    private String review;

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime date;
}
