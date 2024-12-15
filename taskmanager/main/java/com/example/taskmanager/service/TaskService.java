
package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final Map<Integer, Task> taskMap = new HashMap<>();
    private int currentId = 1;

    // Task Management Logic
    public String addTask(Task task) {
        task.setId(currentId++);
        taskMap.put(task.getId(), task);
        return "Task added with ID: " + task.getId();
    }

    public List<Task> getTasks() {
        return new ArrayList<>(taskMap.values());
    }

    public String deleteTask(int id) {
        if (taskMap.remove(id) != null) {
            return "Task with ID: " + id + " deleted.";
        } else {
            return "Task not found.";
        }
    }

    // Math Operations
    public int calculate(String operation, int a, int b) {
        switch (operation) {
            case "add":
                return a + b;
            case "subtract":
                return a - b;
            case "multiply":
                return a * b;
            case "divide":
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    // String Manipulations
    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public Map<String, Integer> countVowelsAndConsonants(String input) {
        int vowels = 0, consonants = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("vowels", vowels);
        result.put("consonants", consonants);
        return result;
    }
}
