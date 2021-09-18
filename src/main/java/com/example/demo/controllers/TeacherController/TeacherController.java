package com.example.demo.controllers.TeacherController;

import com.example.demo.models.Teacher;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> returnTeachers() { return this.teacherService.returnTeachers();
    }

    @PostMapping
    public void createTeacher(@RequestBody Teacher teacher) {
        this.teacherService.createNewTeacher(teacher);
    }

    @PutMapping
    public void updateTeacher(@RequestBody Teacher teacher) {
        this.teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        this.teacherService.deleteTeacher(teacherId);
    }

}
