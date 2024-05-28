package com.matrix_generator.matrix_generator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Builder
public class MatrixDto {

    @JsonProperty("task")
    String task;

    @JsonProperty("matrix")
    String matrix;
}
