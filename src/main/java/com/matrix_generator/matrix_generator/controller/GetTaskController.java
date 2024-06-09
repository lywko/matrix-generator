package com.matrix_generator.matrix_generator.controller;

import com.matrix_generator.matrix_generator.dto.TaskRequestDto;
import com.matrix_generator.matrix_generator.tasks.TaskGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generator")
public class GetTaskController {
    private final TaskGenerator matrixTask;
    private final TaskGenerator polynomialTask;
    private final TaskGenerator vectorTask;

    public GetTaskController(TaskGenerator matrixTask, TaskGenerator polynomialTask, TaskGenerator vectorTask) {
        this.matrixTask = matrixTask;
        this.polynomialTask = polynomialTask;
        this.vectorTask = vectorTask;
    }

    @PostMapping("/getTask")
    public ResponseEntity<Map<String, Object>> getTask(@RequestBody TaskRequestDto taskRequestDto) {
        String taskType = taskRequestDto.getTaskType();
        System.out.println("получен запрос");
        System.out.println(taskRequestDto.getCount());
        System.out.println(taskRequestDto.getTaskType());

        Map<String, Object> response = new HashMap<>();
        response.put("message","Сгенерированные задания");
        List responseList = new ArrayList<>();

        switch (taskType) {
            case "Matrix":
                responseList = matrixTask.generateTasks(taskRequestDto.getCount());
                break;
            case "Vector":
                responseList = vectorTask.generateTasks(taskRequestDto.getCount());
                break;
            case "Polynomial":
                responseList = polynomialTask.generateTasks(taskRequestDto.getCount());
                break;
        }

        response.put("result", responseList);

        return ResponseEntity.ok(response);
    }
}
