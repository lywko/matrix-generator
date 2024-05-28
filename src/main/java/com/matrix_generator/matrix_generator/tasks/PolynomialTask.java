package com.matrix_generator.matrix_generator.tasks;

import com.matrix_generator.matrix_generator.dto.PolynomialDto;
import com.matrix_generator.matrix_generator.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Qualifier("polynomialTask")
public class PolynomialTask implements TaskGenerator {

    private final RandomNumberGenerator randomNumberGenerator;

    public PolynomialTask(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public List<PolynomialDto> generateTasks(int count) {
        List<PolynomialDto> polynomialTasks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            polynomialTasks.add(randomMethodCaller());
        }

        return polynomialTasks;
    }

    private PolynomialDto randomMethodCaller() {
        Random random = new Random();
        int methodNumber = random.nextInt(3) + 1;
        return switch (methodNumber) {
            case 1 -> defineByGauss();
            case 2 -> elementingUnknown();
            case 3 -> generateCramersRuleTask();
            default -> null;
        };
    }

    public PolynomialDto defineByGauss(){
        String task = "Решить уравнение методом Гаусса";
        int equations = randomNumberGenerator.getRandomNumber(3, 5);
        int variables = 3;
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < equations; i++) {
            int[] coefficients = generateCoefficients(variables);
            String equation = equationToString(coefficients);
            sb.append(equation).append(" = 0\n");
        }
        return PolynomialDto.builder()
                .task(task)
                .polynomial(sb.toString())
                .build();
    }

    public PolynomialDto elementingUnknown(){
        String task = "Решить уравнение методом исключения неизвестных";
        int equations = randomNumberGenerator.getRandomNumber(3, 5);
        int variables = 3;
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < equations; i++) {
            int[] coefficients = generateCoefficients(variables);
            String equation = equationToString(coefficients);
            sb.append(equation).append(" = 0\n");
        }
        return PolynomialDto.builder()
                .task(task)
                .polynomial(sb.toString())
                .build();
    }

    public PolynomialDto generateCramersRuleTask() {
        String task = "Решить уравнение по правилу Крамера";
        int equations = randomNumberGenerator.getRandomNumber(3, 5);
        int variables = 3;
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < equations; i++) {
            int[] coefficients = generateCoefficients(variables);
            String equation = equationToString(coefficients);
            sb.append(equation).append(" = 0\n");
        }
        return PolynomialDto.builder()
                .task(task)
                .polynomial(sb.toString())
                .build();
    }

    private int[] generateCoefficients(int variables) {
        int[] coefficients = new int[variables + 1];
        for (int i = 0; i <= variables; i++) {
            coefficients[i] = randomNumberGenerator.getRandomNumber(-10, 10);
        }

        while (allZero(coefficients)) {
            coefficients[randomNumberGenerator.getRandomNumber(0, variables)] = randomNumberGenerator.getRandomNumber(-10, 10);
        }
        return coefficients;
    }

    private boolean allZero(int[] array) {
        for (int num : array) {
            if (num != 0) return false;
        }
        return true;
    }

    private String equationToString(int[] coefficients) {
        StringBuilder sb = new StringBuilder();
        int degree = coefficients.length - 1;
        for (int i = 0; i <= degree; i++) {
            int coeff = coefficients[i];
            if (coeff == 0) continue;

            if (i > 0 && coeff > 0) {
                sb.append("+");
            }
            sb.append(coeff);
            if (i < degree) {
                sb.append("x").append(i + 1);
            }
        }
        return sb.toString();
    }
}
