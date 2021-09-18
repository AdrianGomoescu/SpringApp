package com.example.demo.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Getter
    @Setter
    private Long teacherId;

    @Getter
    @Setter
    private String teacherFirstName;

    @Getter
    @Setter
    private String teacherLastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private int assignedTopic;

}
