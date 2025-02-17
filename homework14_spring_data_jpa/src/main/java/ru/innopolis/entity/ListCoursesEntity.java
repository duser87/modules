package ru.innopolis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="list_courses")
public class ListCoursesEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity id_student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity id_course;

    private String start_date;

    @NotNull
    private Boolean activity;
}
