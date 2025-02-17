package ru.innopolis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="courses")
public class CourseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long id_course;

    private String start_date;

    @NotNull
    private Boolean activity;

    @OneToMany
    @JoinColumn(referencedColumnName = "fk_lis_course_id")
    private List<ListCoursesEntity> listCourses;
}
