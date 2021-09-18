package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> returnStudents()
    {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void createNewStudent(Student student)
    {
        studentRepository.save(student);
    }

    public void updateStudent(Student student)
    {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId)
    {
        studentRepository.deleteById(studentId);
    }
}
