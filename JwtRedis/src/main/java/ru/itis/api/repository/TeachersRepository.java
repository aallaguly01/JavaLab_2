package ru.itis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.api.models.Teacher;
import java.util.List;

public interface TeachersRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByIsDeletedIsNull();
}
