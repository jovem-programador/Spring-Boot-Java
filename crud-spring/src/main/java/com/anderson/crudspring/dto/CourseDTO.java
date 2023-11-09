package com.anderson.crudspring.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.anderson.crudspring.enums.Category;
import com.anderson.crudspring.enums.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(

        /*
         * Representa o MODEL Curso
        */

        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 2, max = 250) String name,
        @NotNull @ValueOfEnum(enumClass = Category.class) @Length(min = 5, max = 250) String category,
        @NotNull @NotEmpty @Valid List<LessonDTO> lessons

) {

}
