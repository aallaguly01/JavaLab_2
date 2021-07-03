package ru.itis.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.TeacherDto;
import ru.itis.rest.models.Teacher;
import ru.itis.rest.repositories.TeachersRepository;
import ru.itis.rest.security.token.TokenService;

import java.util.List;
import java.util.function.Supplier;

import static ru.itis.rest.dto.TeacherDto.from;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    private TokenService tokenService;

    @Override
    public List<TeacherDto> getAllTeachers(String token) {
        if (token == tokenService.getLoggedUserName())
            return from(teachersRepository.findAllByIsDeletedIsNull());
        return null;
    }



    @Override
    public TeacherDto addTeacher(TeacherDto teacher) {
        Teacher newTeacher = Teacher.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();

        teachersRepository.save(newTeacher);
        return from(newTeacher);
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, TeacherDto teacher) {
        Teacher teacherForUpdate = teachersRepository.findById(teacherId)
                .orElseThrow(IllegalArgumentException::new);
        teacherForUpdate.setFirstName(teacher.getFirstName());
        teacherForUpdate.setLastName(teacher.getLastName());
        teachersRepository.save(teacherForUpdate);
        return from(teacherForUpdate);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacherForDelete = teachersRepository.findById(teacherId)
                .orElseThrow(IllegalArgumentException::new);
        teacherForDelete.setIsDeleted(true);
        teachersRepository.save(teacherForDelete);
    }
}
