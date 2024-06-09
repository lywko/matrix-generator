package com.matrix_generator.matrix_generator.dto.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.matrix_generator.matrix_generator.dto.PolynomialDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Builder
public class PolynomialListDto {

    @JsonProperty("polynomialTasks")
    List<PolynomialDto> polynomialTasks;
}
