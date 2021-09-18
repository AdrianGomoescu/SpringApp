package com.example.demo.controllers.FormController;

import com.example.demo.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/register")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    @PostMapping("/register")
    public String studentSubmit(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "student_result";
    }

}