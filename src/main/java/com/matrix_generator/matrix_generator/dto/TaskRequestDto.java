package com.matrix_generator.matrix_generator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class TaskRequestDto {

    @JsonProperty("taskType")
    String taskType;

    @JsonProperty("count")
    Integer count;
}
