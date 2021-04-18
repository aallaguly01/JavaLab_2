package ru.itis.rest.services;

import ru.itis.rest.dto.CourseDto;
import ru.itis.rest.dto.TeacherDto;
import ru.itis.rest.models.Course;

import java.util.List;

public interface CoursesService {
    List<Course> getAllCourses();

    Course addCourse(CourseDto course);

    Course addTeacherIntoCourse(Long courseId, TeacherDto teacher);
}
