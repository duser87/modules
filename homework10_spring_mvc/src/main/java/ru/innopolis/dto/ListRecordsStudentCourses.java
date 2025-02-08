package ru.innopolis.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListRecordsStudentCourses {
    private String fio;
    private String[] listCourses;
}
