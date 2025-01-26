package ru.innopolis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private Long id;
    private String time;
    private String topic;
    private String text_notes;

}
