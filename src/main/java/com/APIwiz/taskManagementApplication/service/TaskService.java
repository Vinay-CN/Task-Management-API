package com.APIwiz.taskManagementApplication.service;

import com.APIwiz.taskManagementApplication.entity.TaskDetails;
import com.APIwiz.taskManagementApplication.entity.Task;

import java.util.List;

public interface TaskService {
        String createTask(Task task) ;

        String assignTask(Long taskId , List<Long> userIds);

        Task updateTask(Task task , Long taskId) ;

        Task getTaskById(Long taskId);

        String deleteTask(Long taskId);

        List<Task> getAllTasks();

        TaskDetails getTaskStatusOfUser(Long taskId,Long userId);


    List<TaskDetails> getAllTasksStatusOfUser(Long userId);

    List<TaskDetails> getUsersStatusByTaskId(Long taskId);




}
