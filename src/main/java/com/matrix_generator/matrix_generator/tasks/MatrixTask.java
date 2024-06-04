package com.matrix_generator.matrix_generator.tasks;

import com.matrix_generator.matrix_generator.dto.MatrixDto;
import com.matrix_generator.matrix_generator.util.LaTeXConvertor;
import com.matrix_generator.matrix_generator.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Qualifier("matrixTask")
public class MatrixTask implements TaskGenerator{

    private final RandomNumberGenerator randomNumberGenerator;
    private final LaTeXConvertor laTeXConvertor;

    public MatrixTask(RandomNumberGenerator randomNumberGenerator, LaTeXConvertor laTeXConvertor) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.laTeXConvertor = laTeXConvertor;
    }

    @Override
    public List<MatrixDto> generateTasks(int count) {
        List<MatrixDto> matrixTasks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            matrixTasks.add(randomMethodCaller());
        }

        return matrixTasks;
    }

    private MatrixDto randomMethodCaller() {
        Random random = new Random();
        int methodNumber = random.nextInt(4) + 1;
        return switch (methodNumber) {
            case 1 -> defineRang();
            case 2 -> findMatrixByTwo();
            case 3 -> findMirrorMatrix();
            case 4 -> findQuiliferMatrix();
            default -> null;
        };
    }

    public MatrixDto defineRang() {
        String task = "Найти ранг матрицы A:";
        int size = randomNumberGenerator.getRandomNumber(3, 7);
        int[][] matrix = generateMatrix(size, size);

        String matrixString = "A = " + laTeXConvertor.convertMatrix(matrix);


        return MatrixDto.builder()
                .task(task)
                .matrix(matrixString)
                .build();
    }

    public MatrixDto findMatrixByTwo() {
        String task = "Даны матрицы A и B, найти неизвестную матрицу X, удовлетворяющую данному матричному уравнению  (X+A)B=2X";

        int size = randomNumberGenerator.getRandomNumber(3, 7);
        int[][] matrixA = generateMatrix(size, size);
        int[][] matrixB = generateMatrix(size, size);

        String matrixAString = "A = " + laTeXConvertor.convertMatrix(matrixA);
        String matrixBString = "B = " + laTeXConvertor.convertMatrix(matrixB);

        String matrixs = matrixAString + " \\\\ " + ", " + matrixBString;

        return MatrixDto.builder()
                .task(task)
                .matrix(matrixs)
                .build();
    }

    public MatrixDto findMirrorMatrix() {
        String task = "Найти матрицу, обратную матрице A. Сделать проверку";

        int size = randomNumberGenerator.getRandomNumber(3, 7);
        int[][] matrix = generateMatrix(size, size);

        String matrixString = "A = " + laTeXConvertor.convertMatrix(matrix);


        return MatrixDto.builder()
                .task(task)
                .matrix(matrixString)
                .build();
    }

    public MatrixDto findQuiliferMatrix(){
        String task = "Вычислить определитель матрицы A";
        int[][] matrix = generateMatrix(5, 5);

        String matrixString = "A = " + laTeXConvertor.convertMatrix(matrix);


        return MatrixDto.builder()
                .task(task)
                .matrix(matrixString)
                .build();
    }

    private int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = randomNumberGenerator.getRandomNumber(-10, 10);
            }
        }
        return matrix;
    }
}
