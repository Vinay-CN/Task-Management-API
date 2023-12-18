package com.APIwiz.taskManagementApplication.repository;
import com.APIwiz.taskManagementApplication.entity.Task;
import com.APIwiz.taskManagementApplication.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findByDueDateBefore(LocalDate date);
    List<Task> findByStatus(TaskStatus status);

}
