package com.matrix_generator.matrix_generator.tasks;

import com.matrix_generator.matrix_generator.dto.VectorDto;
import com.matrix_generator.matrix_generator.util.RandomNumberGenerator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("vectorTask")
public class VectorTask implements TaskGenerator {

    private final RandomNumberGenerator randomNumberGenerator;

    public VectorTask(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public List<VectorDto> generateTasks(int count) {
        List<VectorDto> vectorTasks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            vectorTasks.add(randomMethodCaller());
        }

        return vectorTasks;
    }

    private VectorDto randomMethodCaller() {
        Random random = new Random();
        int methodNumber = random.nextInt(5) + 1;
        return switch (methodNumber) {
            case 1 -> vectorDecomposition();
            case 2 -> findPoint();
            case 3 -> defineTriangSquare();
            case 4 -> isComplanar();
            case 5 -> isLinearDependent();
            default -> null;
        };
    }

    public VectorDto vectorDecomposition() {
        String task = "Написать разложение вектора X по векторам (a,b,c)";

        int x1 = randomNumberGenerator.getRandomNumber(-10, 10);
        int x2 = randomNumberGenerator.getRandomNumber(-10, 10);
        int x3 = randomNumberGenerator.getRandomNumber(-10, 10);

        int a1 = randomNumberGenerator.getRandomNumber(-10, 10);
        int a2 = randomNumberGenerator.getRandomNumber(-10, 10);
        int a3 = randomNumberGenerator.getRandomNumber(-10, 10);

        int b1 = randomNumberGenerator.getRandomNumber(-10, 10);
        int b2 = randomNumberGenerator.getRandomNumber(-10, 10);
        int b3 = randomNumberGenerator.getRandomNumber(-10, 10);

        int c1 = randomNumberGenerator.getRandomNumber(-10, 10);
        int c2 = randomNumberGenerator.getRandomNumber(-10, 10);
        int c3 = randomNumberGenerator.getRandomNumber(-10, 10);

        String vector = String.format(" X=(%d;%d;%d), \n a=(%d;%d;%d),\n b=(%d;%d;%d),\n c=(%d;%d;%d)",
                x1, x2, x3, a1, a2, a3, b1, b2, b3, c1, c2, c3);



        return VectorDto.builder().
                task(task).
                vector(vector).
                build();
    }

    public VectorDto findPoint() {
        String task = "На оси Ox найти точку, равноудаленную от точек A и B.";

        int ax = randomNumberGenerator.getRandomNumber(-10, 10);
        int ay = randomNumberGenerator.getRandomNumber(-10, 10);
        int az = randomNumberGenerator.getRandomNumber(-10, 10);

        int bx = randomNumberGenerator.getRandomNumber(-10, 10);
        int by = randomNumberGenerator.getRandomNumber(-10, 10);
        int bz = randomNumberGenerator.getRandomNumber(-10, 10);

        String vector = String.format(" A(%d;%d;%d);\n B(%d;%d;%d)",ax, ay, az, bx, by, bz);

        return VectorDto.builder().
                task(task).
                vector(vector).
                build();
    }

    public VectorDto defineTriangSquare() {
        String task = "Вычислить площадь треугольника с вершинами";

        int ax = randomNumberGenerator.getRandomNumber(-10, 10);
        int ay = randomNumberGenerator.getRandomNumber(-10, 10);
        int az = randomNumberGenerator.getRandomNumber(-10, 10);

        int bx = randomNumberGenerator.getRandomNumber(-10, 10);
        int by = randomNumberGenerator.getRandomNumber(-10, 10);
        int bz = randomNumberGenerator.getRandomNumber(-10, 10);

        int cx = randomNumberGenerator.getRandomNumber(-10, 10);
        int cy = randomNumberGenerator.getRandomNumber(-10, 10);
        int cz = randomNumberGenerator.getRandomNumber(-10, 10);

        String vector = String.format(" A=(%d;%d;%d),\n B=(%d;%d;%d),\n C=(%d;%d;%d)",
                ax, ay, az, bx, by, bz, cx, cy, cz);

        return VectorDto.builder().
                task(task).
                vector(vector).
                build();
    }

    public VectorDto isComplanar() {
        String task = "Компланарны ли векторы a,b,c?";

        int ax = randomNumberGenerator.getRandomNumber(-10, 10);
        int ay = randomNumberGenerator.getRandomNumber(-10, 10);
        int az = randomNumberGenerator.getRandomNumber(-10, 10);

        int bx = randomNumberGenerator.getRandomNumber(-10, 10);
        int by = randomNumberGenerator.getRandomNumber(-10, 10);
        int bz = randomNumberGenerator.getRandomNumber(-10, 10);

        int cx = randomNumberGenerator.getRandomNumber(-10, 10);
        int cy = randomNumberGenerator.getRandomNumber(-10, 10);
        int cz = randomNumberGenerator.getRandomNumber(-10, 10);

        String vector = String.format(" a=(%d;%d;%d),\n b=(%d;%d;%d),\n c=(%d;%d;%d)",
                ax, ay, az, bx, by, bz, cx, cy, cz);

        return VectorDto.builder().
                task(task).
                vector(vector).
                build();
    }

    public VectorDto isLinearDependent() {
        String task = "Являются ли следующие системы векторов линейно зависимыми или линейно независимыми";

        int ax = randomNumberGenerator.getRandomNumber(-10, 10);
        int ay = randomNumberGenerator.getRandomNumber(-10, 10);
        int az = randomNumberGenerator.getRandomNumber(-10, 10);

        int bx = randomNumberGenerator.getRandomNumber(-10, 10);
        int by = randomNumberGenerator.getRandomNumber(-10, 10);
        int bz = randomNumberGenerator.getRandomNumber(-10, 10);

        String vector = String.format(" a1=(%d;%d;%d),\n a2=(%d;%d;%d)",
                ax, ay, az, bx, by, bz);

        return VectorDto.builder().
                task(task).
                vector(vector).
                build();
    }
}
