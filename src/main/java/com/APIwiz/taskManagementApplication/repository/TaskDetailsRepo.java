package com.APIwiz.taskManagementApplication.repository;

import com.APIwiz.taskManagementApplication.entity.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDetailsRepo extends JpaRepository<TaskDetails, Long > {

}
