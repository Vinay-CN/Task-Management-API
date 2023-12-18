package com.APIwiz.taskManagementApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.* ;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.APIwiz.taskManagementApplication.enums.TaskStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tasksList")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long taskId ;
    @Column(name = "title" , nullable = false , columnDefinition = "VARCHAR(100)" )
    private String title ;

    @Column(name = "description" ,  columnDefinition = "TEXT")
    private String description ;

    @CreationTimestamp
    LocalDate  created ;
    @Column(name = "due_date" , nullable = false)
    private LocalDate dueDate ;
    @Enumerated(EnumType.STRING)
    private TaskStatus status ;

    @ManyToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<User> users = new ArrayList<>();
    // @Embedded

    @OneToMany
    private List<TaskDetails> assignedUsersAndStatus = new ArrayList<>();


}
