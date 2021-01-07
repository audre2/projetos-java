package br.com.demotwitter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.demotwitter.model.StudentEntity;
import br.com.demotwitter.repository.StudentRepository;

@Service
public class StudentService {
	
	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	StudentRepository repository;
	
	// Save student entity in the h2 database.
	public void save (StudentEntity student) {
		repository.save(student);
	}

	// Get all students from the h2 database.
	public List<StudentEntity> getAll() {
		List<StudentEntity> students = new ArrayList<StudentEntity>();
		repository.findAll().forEach(student -> students.add(student));
		return students;
	}
}
