package ru.itis.api.services;


import ru.itis.api.dto.TeacherDto;

import java.util.List;

public interface TeachersService {
    List<TeacherDto> getAllTeachers();

    TeacherDto addTeacher(TeacherDto teacher);
}
