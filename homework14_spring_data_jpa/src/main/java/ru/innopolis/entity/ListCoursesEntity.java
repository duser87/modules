package ru.innopolis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="list_courses", schema = "student")
public class ListCoursesEntity{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "id_student")
    private Long id_student;

    @Column(name = "id_course")
    private Long id_course;

    @Column(name = "start_date")
    private String start_date;

    @NotNull
    @Column(name = "activity")
    private Boolean activity;
}
