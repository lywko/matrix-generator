package com.matrix_generator.matrix_generator.util;

import org.springframework.stereotype.Service;

@Service
public class LaTeXConvertor {

    public String convertMatrix (int[][] matrix) {
        StringBuilder latex = new StringBuilder();
        latex.append("\\begin{bmatrix}");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                latex.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    latex.append(" & ");
                }
            }
            if (i < matrix.length - 1) {
                latex.append(" \\\\ ");
            }
        }
        latex.append("\\end{bmatrix}");
        return latex.toString();
    }

    public String convertEquation(int[] coefficients) {
        StringBuilder sb = new StringBuilder();
        int degree = coefficients.length - 1;
        for (int i = 0; i < degree; i++) {
            int coeff = coefficients[i];
            if (coeff == 0) continue;

            if (i > 0 && coeff > 0) {
                sb.append("+");
            }
            sb.append(coeff);
            if (i < degree - 1) {
                sb.append("x_").append(i + 1);
            }
        }
        int constant = coefficients[degree];
        if (constant > 0) {
            sb.append("+").append(constant);
        } else if (constant < 0) {
            sb.append(constant);
        }
        return sb.toString();
    }
}
