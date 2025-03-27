package ru.innopolis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="list_courses", schema = "security")
public class ListCoursesEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "id_student")
    private Long idStudent;

    @Column(name = "id_course")
    private Long idCourse;

    @Column(name = "start_date")
    @CreationTimestamp
    private String startDate;

    @NotNull
    @Column(name = "activity")
    private Boolean activity;
}