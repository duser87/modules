package ru.innopolis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {

    private Long id;
    private Long id_d;
    private Long id_p;
    private String time;
    private String description;

}