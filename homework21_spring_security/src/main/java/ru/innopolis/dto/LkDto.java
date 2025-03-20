package ru.innopolis.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LkDto {
    private List<CoursesResponse> courses;
}
