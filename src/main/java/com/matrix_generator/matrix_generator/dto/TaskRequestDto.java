package com.matrix_generator.matrix_generator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@SuperBuilder
public class TaskRequestDto {

    @JsonProperty("taskType")
    String taskType;

    @JsonProperty("count")
    Integer count;
}
