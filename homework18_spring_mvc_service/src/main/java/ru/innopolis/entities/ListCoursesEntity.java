package ru.innopolis.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_courses", schema = "student")
public class ListCoursesEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "id_student")
    private Long idStudent;

    @NotNull
    @Column(name = "id_course")
    private Long idCourse;

    @Column(name = "date_start")
    private String dateStart;

    @NotNull
    @Column(name = "activity")
    private Boolean activity;
}

