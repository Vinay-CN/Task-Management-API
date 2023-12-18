package com.APIwiz.taskManagementApplication.service;

import com.APIwiz.taskManagementApplication.entity.Task;
import com.APIwiz.taskManagementApplication.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    String changePassword(Long userId , String oldPassword , String newPassword) ;

    String changeUsername(Long userId , String userName) ;
    String deleteUser(Long userId) ;

    User getUserTasksById(Long userId) ;
    List<User> getAllUsers();

//    List<Task> getTasksByUserId(Long userId);


}
