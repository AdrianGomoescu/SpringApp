package com.example.demo.controllers.StudentController;

import com.example.demo.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class StudentControllerIntegrationTest {

    @Autowired
    private StudentController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
        System.out.println("Controller is working!");

        Student student = new Student();
        student.setStudentId(11L);
        student.setFirstName("Jim");
        student.setLastName("Monroe");
        student.setEmail("jim@monroe.com");
        student.setAverageScore((float) 6.86);

        controller.createStudent(student);
        System.out.println("Student created!");

        controller.deleteStudent(student.getStudentId());
        System.out.println("Student deleted!");
    }
}