package com.anderson.crudspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.anderson.crudspring.model.Course;
import com.anderson.crudspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    // GET ALL
    public List<Course> list() {
        return courseRepository.findAll();
    }

    // GET ID
    public Optional<Course> findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id);
    }

    // POST
    public Course create(@Valid Course course) {
        return courseRepository.save(course);
    }

    // UPDATE
    public Optional<Course> update(@NotNull @Positive Long id, @Valid Course course) {

        return courseRepository.findById(id).map(recordFound -> {

            recordFound.setName(course.getName());
            recordFound.setCategory(course.getCategory());

            return courseRepository.save(recordFound);

        });
    }

    // DELETE
    public boolean delete(@PathVariable @NotNull @Positive Long id) {

        return courseRepository.findById(id)

        .map(recordFound -> {
            courseRepository.deleteById(id);
            return true;
        })
        .orElse(false);
    }
}
