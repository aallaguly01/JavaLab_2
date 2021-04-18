package ru.itis.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.models.Lesson;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}
