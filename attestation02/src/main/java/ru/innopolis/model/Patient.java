package ru.innopolis.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {

    private Long id;
    private String fio;
    private String tel;
    private String address;

}