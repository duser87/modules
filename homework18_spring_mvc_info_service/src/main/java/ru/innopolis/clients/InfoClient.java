package ru.innopolis.clients;

import ru.innopolis.dto.CourseResponse;
import ru.innopolis.dto.InfoResponse;

import java.util.List;

public interface InfoClient {
    CourseResponse getCourse(Long id);
}
