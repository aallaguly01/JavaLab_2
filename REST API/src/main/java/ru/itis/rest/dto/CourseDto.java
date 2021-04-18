package ru.itis.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {
    private String title;
    private List<String> teachers;
}
