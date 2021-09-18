package com.example.demo.services;

import com.example.demo.models.Teacher;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    public List<Teacher> returnTeachers()
    {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    public void createNewTeacher(Teacher teacher)
    {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher)
    {
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId)
    {
        teacherRepository.deleteById(teacherId);
    }
}
