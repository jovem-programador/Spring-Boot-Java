package com.anderson.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.anderson.crudspring.dto.CourseDTO;
import com.anderson.crudspring.dto.mapper.CourseMapper;
import com.anderson.crudspring.exception.RecordNotFoundException;
import com.anderson.crudspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {

    /*
     * Class de Serviço da API 
    */

    // Repositorio Instancia
    private final CourseRepository courseRepository;

    // Mapeamento Instancia
    private final CourseMapper courseMapper;

    // Construtor
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {

        // Iniciando as instancias
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    // GET ALL
    public List<CourseDTO> list() {
        return courseRepository.findAll()
        .stream()
        .map(courseMapper::toDTO)
        .collect(Collectors.toList());
    }

    // GET ID
    public CourseDTO findById(@NotNull @Positive Long id) {
        return courseRepository.findById(id).map(courseMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    // POST
    public CourseDTO create(@Valid @NotNull CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    // UPDATE
    public CourseDTO update(@NotNull @Positive Long id, @Valid @NotNull CourseDTO course) {

        return courseRepository.findById(id).map(recordFound -> {

            recordFound.setName(course.name());
            recordFound.setCategory(courseMapper.convertCategoryValue(course.category()));

            return courseRepository.save(recordFound);

        }).map(courseMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    // DELETE
    public void delete(@NotNull @Positive Long id) {

        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
