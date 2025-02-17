package ru.innopolis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @JoinColumn(name = "id")
    private StudentEntity id_student;

    @ManyToOne
    @JoinColumn(referencedColumnName = "fk_course_id")
    private CourseEntity id_course;
}
