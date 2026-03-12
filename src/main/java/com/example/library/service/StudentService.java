package com.example.library.service;

import com.example.library.model.Student;
import com.example.library.repositry.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
}