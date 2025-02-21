package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestJson {
    private String Name;
    private String Country;
    private String House;
    private String Reign;
    private Integer ID;
}
