package com.APIwiz.taskManagementApplication.controller;

import com.APIwiz.taskManagementApplication.DTO.listDTO;
import com.APIwiz.taskManagementApplication.entity.TaskDetails;
import com.APIwiz.taskManagementApplication.entity.Task;
import com.APIwiz.taskManagementApplication.enums.TaskStatus;
import com.APIwiz.taskManagementApplication.service.implementation.TaskServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("task")
@PreAuthorize("hasRole('ADMIN')")
public class TaskController {

    // Autowired service
    @Autowired
    private TaskServiceImplementation taskServiceImplementation;

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    // Create a new task

    @PostMapping("/createTask")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        // Log information about the request and result
        log.info("Received request to create task: {}", task);
        taskServiceImplementation.createTask(task);
        log.info("Task created successfully with ID: {}", task.getTaskId());
        return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully.");
    }

    // Assign task to users
    @PostMapping("/assignTask/{taskId}")
    public ResponseEntity<String> assignTask(@PathVariable Long taskId, @RequestBody listDTO userIds) {
        try {
            List<Long> usersId = userIds.getUserIds();
            log.info("Assigning task {} to users: {}", taskId, usersId);
            taskServiceImplementation.assignTask(taskId, usersId);
            log.info("Task assigned successfully to users: {}", usersId);
            return ResponseEntity.status(HttpStatus.OK).body("Tasks assigned successfully.");
        } catch (Exception e) {
            log.error("Error assigning task {}: {}", taskId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
        }
    }

    // Update task details
    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity<String> updateTask(@RequestBody Task task, @PathVariable Long taskId) {
        try {
            taskServiceImplementation.updateTask(task, taskId);
            log.info("Task {} updated successfully", taskId);
            return ResponseEntity.status(HttpStatus.OK).body("Task updated successfully.");
        } catch (Exception e) {
            log.error("Error updating task {}: {}", taskId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
        }
    }

    // Get task details by ID
    @GetMapping("/getTaskById/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        try {
            Task task = taskServiceImplementation.getTaskById(taskId);
            log.info("Retrieved details for task {}: {}", taskId, task);
            return ResponseEntity.status(HttpStatus.OK).body(task);
        } catch (Exception e) {
            log.error("Error getting details for task {}: {}", taskId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Delete task by ID
    @DeleteMapping("/deleteTaskById/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long taskId) {
        try {
            taskServiceImplementation.deleteTask(taskId);
            log.info("Task {} deleted successfully", taskId);
            return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully.");
        } catch (Exception e) {
            log.error("Error deleting task {}: {}", taskId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
        }
    }

    // Get all tasks with pagination
    @GetMapping("/getAllTasksPaginated")
    public ResponseEntity<Page<Task>> getAllTasksPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Task> tasks = taskServiceImplementation.getAllTasksPaginated(page, size);
        log.info("Retrieved paginated tasks: {}", tasks);
        return ResponseEntity.ok(tasks);
    }

    // Get task details for a user by task ID
    @GetMapping("/getTaskStatusOfUser/{taskId}")
    public ResponseEntity<TaskDetails> getTaskStatusOfUser(@PathVariable Long taskId, @RequestParam Long userId) {
        try {
            TaskDetails taskDetails = taskServiceImplementation.getTaskStatusOfUser(taskId, userId);
            log.info("Task details for task {} and user {}: {}", taskId, userId, taskDetails);
            return ResponseEntity.status(HttpStatus.OK).body(taskDetails);
        } catch (Exception e) {
            log.error("Error getting task details for task {} and user {}: {}", taskId, userId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Get task details for all tasks of a user
    @GetMapping("/getAllTasksStatusOfUser/{userId}")
    public ResponseEntity<List<TaskDetails>> getAllTasksStatusOfUser(@PathVariable Long userId) {
        List<TaskDetails> taskDetailsList = taskServiceImplementation.getAllTasksStatusOfUser(userId);
        log.info("Task details for all tasks of user {}: {}", userId, taskDetailsList);
        return ResponseEntity.status(HttpStatus.OK).body(taskDetailsList);
    }

    // Get task details for all users of a task
    @GetMapping("/getUsersStatusByTaskId/{taskId}")
    public ResponseEntity<List<TaskDetails>> getUsersStatusByTaskId(@PathVariable Long taskId) {
        List<TaskDetails> taskDetailsList = taskServiceImplementation.getUsersStatusByTaskId(taskId);
        log.info("Task details for all users of task {}: {}", taskId, taskDetailsList);
        return ResponseEntity.status(HttpStatus.OK).body(taskDetailsList);
    }

        @GetMapping("/tasksDueBefore")
        public ResponseEntity<List<Task>> getTasksDueBefore(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
            List<Task> tasks = taskServiceImplementation.getTasksDueBefore(date);
            return ResponseEntity.ok(tasks);
        }

    @GetMapping("/tasksByStatus")
    public ResponseEntity<List<Task>> getTasksByStatus(@RequestParam TaskStatus status) {
        List<Task> tasks = taskServiceImplementation.getTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }
}
