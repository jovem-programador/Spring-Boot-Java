package com.anderson.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.anderson.crudspring.dto.CourseDTO;
import com.anderson.crudspring.enums.Category;
import com.anderson.crudspring.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {

        if (course == null) {
            return null;
        }

        return new CourseDTO(course.getId(), course.getName(), "Front-End");
    }

    public Course toEntity(CourseDTO courseDTO) {

        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();

        if (courseDTO.id() != 0) {
            course.setId(courseDTO.id());
        }

        course.setName(courseDTO.name());
        course.setCategory(Category.FRONT_END);

        return course;
    }
}
