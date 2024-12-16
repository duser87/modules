package ru.innopolis.entity;

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
    private Long id_doc;
    private Long id_client;
    private String time;
    private String description;

}

