package com.example.demo.controllers.StudentController;

import com.example.demo.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;


@DataJpaTest
@AutoConfigureTestDatabase( replace =
AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
public class StudentControllerUnitTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void createStudent() {
        Student student = new Student();
        student.setStudentId(11L);
        student.setFirstName("Jim");
        student.setLastName("Monroe");
        student.setEmail("jim@monroe.com");
        student.setAverageScore((float) 6.86);

        entityManager.persist(student);
        entityManager.flush();
        entityManager.clear();
    }
}