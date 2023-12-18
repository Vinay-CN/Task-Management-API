package com.APIwiz.taskManagementApplication.repository;

import com.APIwiz.taskManagementApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<Object> findByUsername(String username);
}
