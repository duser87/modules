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
@Table(name="courses", schema = "student")
public class CourseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Boolean activity;

    @OneToMany(mappedBy = "course")
    List<ListCoursesEntity> listCoursesEntities;

}
