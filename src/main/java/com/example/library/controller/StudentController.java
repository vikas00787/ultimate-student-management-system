package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.library.model.Student;
import com.example.library.repositry.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	// Student List
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "students";
	}

	// Add Student Page
	@GetMapping("/addStudent")
	public String showAddStudentPage(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}

	// Save Student
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student student) {
		studentRepository.save(student);
		return "redirect:/students";
	}

	// Delete Student
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentRepository.deleteById(id);
		return "redirect:/students";
	}
}