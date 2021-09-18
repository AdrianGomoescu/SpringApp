package com.example.demo.controllers.StudentController;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> returnStudents() { return this.studentService.returnStudents(); }

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        this.studentService.createNewStudent(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student) {
        this.studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        this.studentService.deleteStudent(studentId);
    }

}