package com.APIwiz.taskManagementApplication.service.implementation;

import com.APIwiz.taskManagementApplication.entity.Task;
import com.APIwiz.taskManagementApplication.entity.User;
import com.APIwiz.taskManagementApplication.repository.TaskRepo;
import com.APIwiz.taskManagementApplication.repository.UserRepo;
import com.APIwiz.taskManagementApplication.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImplementation.class);

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public User addUser(User user) {
        userRepo.save(user);
        log.info("User added successfully: {}", user);
        return user;
    }

    @Override
    public String changePassword(Long userId, String oldPassword, String newPassword) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                log.info("Password changed successfully for user: {}", user);
                return "Password changed successfully";
            } else {
                log.warn("Wrong password for user: {}", user);
                return "Wrong password";
            }
        }
        throw new EntityNotFoundException("User not found for the provided userId");
    }

    @Override
    public String changeUsername(Long userId, String userName) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userName);
            log.info("Username changed successfully for user: {}", user);
            return "Username changed successfully";
        }
        throw new EntityNotFoundException("User not found for the provided userId");
    }

    @Override
    public String deleteUser(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            userRepo.deleteById(userId);
            log.info("User deleted successfully. User ID: {}", userId);
            return "User deleted successfully";
        }
        throw new EntityNotFoundException("User not found for the provided userId");
    }

    @Override
    public User getUserTasksById(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found for the provided userId"));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        log.info("Retrieved all users: {}", users);
        return users;
    }

    public Page<Task> getAllTasksPaginated(int page, int size) {
        return taskRepo.findAll(PageRequest.of(page, size));
    }

}
