
package com.example.taskmanager.controller;

import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Task Management Endpoints
    @PostMapping("/tasks")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    // Math Operations
    @GetMapping("/math/{operation}")
    public ResponseEntity<Integer> calculate(@PathVariable String operation,
                                             @RequestParam int a,
                                             @RequestParam int b) {
        return ResponseEntity.ok(taskService.calculate(operation, a, b));
    }

    // String Manipulations
    @GetMapping("/strings/reverse")
    public ResponseEntity<String> reverseString(@RequestParam String input) {
        return ResponseEntity.ok(taskService.reverseString(input));
    }

    @GetMapping("/strings/count")
    public ResponseEntity<Map<String, Integer>> countVowelsAndConsonants(@RequestParam String input) {
        return ResponseEntity.ok(taskService.countVowelsAndConsonants(input));
    }
}
