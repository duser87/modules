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
    @ManyToMany
    @JoinColumn(name = "id")
    private List<StudentEntity> id_student;
    @ManyToMany
    @JoinColumn(referencedColumnName = "fk_course_id")
    private List<CourseEntity> id_course;
}
