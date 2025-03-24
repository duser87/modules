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
@Table(name = "reviews", schema = "security")
public class ReviewEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "id_student")
    private Long idStudent;

    @Column(name = "id_course")
    private Long idCourse;

    @Column(name = "review")
    private String review;

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime date;
}
