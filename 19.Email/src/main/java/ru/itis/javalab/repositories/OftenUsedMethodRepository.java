package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.OftenUsedMethodModel;

import java.util.Optional;

public interface OftenUsedMethodRepository extends JpaRepository<OftenUsedMethodModel, Long> {
    Optional<OftenUsedMethodModel> getByMethodName(String methodName);
}
