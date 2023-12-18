package com.APIwiz.taskManagementApplication.entity;
import com.APIwiz.taskManagementApplication.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;
//@Embeddable
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;
    private LocalDate dueDate;

}
