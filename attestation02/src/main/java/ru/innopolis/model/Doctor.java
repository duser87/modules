package ru.innopolis.model;

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
    private Long id_pos;
    private String fio_d;
    private String tel_d;

}