package ru.innopolis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students", schema = "student")
public class StudentEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "fio")
    private String fio;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "age")
    private Integer age;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "list_courses",
//            joinColumns = { @JoinColumn(name = "id_student") },
//            inverseJoinColumns = { @JoinColumn(name = "id_course") }
//    )
//    private Set<CourseEntity> courses;

}
