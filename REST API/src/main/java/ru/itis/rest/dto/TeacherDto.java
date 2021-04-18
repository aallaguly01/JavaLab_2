package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.rest.models.Course;
import ru.itis.rest.models.Teacher;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<String> courses;

    public static TeacherDto from(Teacher teacher) {
        TeacherDto result = TeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();

        if (teacher.getCourses() != null) {
            result.setCourses((teacher.getCourses().stream().map(Course::getTitle).collect(Collectors.toList())));
        }
        return result;
    }

    public static List<TeacherDto> from(List<Teacher> teachers) {
        return teachers.stream().map(TeacherDto::from).collect(Collectors.toList());
    }
}
