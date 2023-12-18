package com.APIwiz.taskManagementApplication.DTO;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class listDTO {
    private List<Long> userIds ;

}
