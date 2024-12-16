package ru.innopolis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor {

    private Long id;
    private String fio;
    private String position;
    private String tel;

}
