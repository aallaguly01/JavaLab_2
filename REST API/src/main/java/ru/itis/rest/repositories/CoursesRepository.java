package ru.itis.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.models.Course;

public interface CoursesRepository extends JpaRepository<Course, Long> {
}
