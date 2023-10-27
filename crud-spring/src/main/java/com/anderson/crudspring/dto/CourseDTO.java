package com.anderson.crudspring.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CourseDTO(

        /*
         * Representa o MODEL Curso
        */

        @JsonProperty("_id") long id,
        @NotBlank @NotNull @Length(min = 2, max = 250) String name,
        @NotNull @Pattern(regexp = "Back-End|Front-End") @Length(min = 5, max = 250) String category,
        List<LessonDTO> lessons

) {

}
