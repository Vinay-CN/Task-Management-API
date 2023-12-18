package com.APIwiz.taskManagementApplication;

import com.APIwiz.taskManagementApplication.entity.Task;
import com.APIwiz.taskManagementApplication.entity.TaskDetails;
import com.APIwiz.taskManagementApplication.entity.User;
import com.APIwiz.taskManagementApplication.repository.TaskDetailsRepo;
import com.APIwiz.taskManagementApplication.repository.TaskRepo;
import com.APIwiz.taskManagementApplication.repository.UserRepo;
import com.APIwiz.taskManagementApplication.service.implementation.TaskServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TaskServiceImplementationTest {

    @Mock
    private TaskRepo taskRepository;

    @Mock
    private UserRepo userRepository;

    @Mock
    private TaskDetailsRepo taskDetailsRepo;

    @InjectMocks
    private TaskServiceImplementation taskService;

    @Test
    void getTaskById() {
        Long taskId = 1L;
        Task task = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        Task result = taskService.getTaskById(taskId);

        assertEquals(task, result);
    }

    @Test
    void getTaskByIdNotFound() {
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> taskService.getTaskById(taskId));
    }

    @Test
    void deleteTask() {
        Long taskId = 1L;

        assertDoesNotThrow(() -> taskService.deleteTask(taskId));
    }

    @Test
    void getAllTasks() {
        List<Task> tasks = List.of(new Task(), new Task(), new Task());
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(tasks.size(), result.size());
    }


    @Test
    void getTaskStatusOfUser() {
        Long taskId = 1L;
        Long userId = 1L;
        TaskDetails taskDetails = new TaskDetails();
        when(taskService.getTaskDetails(taskId, userId)).thenReturn(taskDetails);

        TaskDetails result = taskService.getTaskStatusOfUser(taskId, userId);

        assertEquals(taskDetails, result);
    }

    @Test
    void getTaskStatusOfUserNotFound() {
        Long taskId = 1L;
        Long userId = 1L;
        when(taskService.getTaskDetails(taskId, userId)).thenThrow(ResponseStatusException.class);

        assertThrows(ResponseStatusException.class, () -> taskService.getTaskStatusOfUser(taskId, userId));
    }

    @Test
    void getAllTasksStatusOfUser() {
        Long userId = 1L;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        List<TaskDetails> result = taskService.getAllTasksStatusOfUser(userId);

        assertNotNull(result);
    }

    @Test
    void getUsersStatusByTaskId() {
        Long taskId = 1L;
        Task task = new Task();
        when(taskService.getTaskById(taskId)).thenReturn(task);

        List<TaskDetails> result = taskService.getUsersStatusByTaskId(taskId);

        assertNotNull(result);
    }




}

