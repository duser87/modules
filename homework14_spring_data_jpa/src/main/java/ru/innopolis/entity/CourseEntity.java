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
@Table(name="courses", schema = "student")
public class CourseEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "activity")
    private Boolean activity;

//    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
//    private Set<StudentEntity> students;

}
