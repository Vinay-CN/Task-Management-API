package com.APIwiz.taskManagementApplication.controller;

import com.APIwiz.taskManagementApplication.entity.Task;
import com.APIwiz.taskManagementApplication.entity.User;
import com.APIwiz.taskManagementApplication.service.UserService;
import com.APIwiz.taskManagementApplication.service.implementation.UserServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
class UserController {

    // Autowired service
    @Autowired
    private UserServiceImplementation userService;
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    // Add a new user
    @PostMapping("/addUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        // Log information about the request and result
        log.info("Received request to add user: {}", user);
        User addedUser = userService.addUser(user);
        log.info("User added successfully with ID: {}", addedUser.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
    }

    // Change user password
    @PutMapping("/changePassword/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> changePassword(@PathVariable Long userId,
                                                 @RequestParam String oldPassword,
                                                 @RequestParam String newPassword) {
        try {
            String result = userService.changePassword(userId, oldPassword, newPassword);
            log.info("Password changed successfully for user {}", userId);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            log.error("Error changing password for user {}: {}", userId, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Change user username
    @PutMapping("/changeUsername/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> changeUsername(@PathVariable Long userId,
                                                 @RequestParam String newUsername) {
        try {
            String result = userService.changeUsername(userId, newUsername);
            log.info("Username changed successfully for user {}", userId);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            log.error("Error changing username for user {}: {}", userId, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Delete user by ID
    @DeleteMapping("/deleteUser/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        try {
            String result = userService.deleteUser(userId);
            log.info("User {} deleted successfully", userId);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            log.error("Error deleting user {}: {}", userId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Get user details by ID
    @GetMapping("/getUserTasksById/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        try {
            User user = userService.getUserTasksById(userId);
            log.info("Retrieved details for user {}: {}", userId, user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (Exception e) {
            log.error("Error getting details for user {}: {}", userId, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Get details for all users
    @GetMapping("/getAllUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        log.info("Retrieved details for all users: {}", users);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/getAllTasksPaginated")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<Task>> getAllTasksPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Task> tasks = userService.getAllTasksPaginated(page, size);
        log.info("Retrieved paginated tasks: {}", tasks);
        return ResponseEntity.ok(tasks);
    }

}
