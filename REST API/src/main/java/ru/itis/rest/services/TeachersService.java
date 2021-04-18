package ru.itis.rest.services;

import ru.itis.rest.dto.TeacherDto;
import ru.itis.rest.models.Teacher;

import java.util.List;

public interface TeachersService {
    List<TeacherDto> getAllTeachers();

    TeacherDto addTeacher(TeacherDto teacher);

    TeacherDto updateTeacher(Long teacherId, TeacherDto teacher);

    void deleteTeacher(Long teacherId);
}
