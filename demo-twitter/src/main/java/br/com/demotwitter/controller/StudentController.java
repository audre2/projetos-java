package br.com.demotwitter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.demotwitter.model.StudentEntity;
import br.com.demotwitter.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
    // Save student entity in the h2 database.
    // @PostMapping annotation handles the http post request matched with the given uri.
    // @RequestBody annotation binds the http request body to the domain object.
    // @Valid annotation validates a model after binding the user input to it.
	@PostMapping("/student")
	public StudentEntity save(final @RequestBody @Valid StudentEntity student) {
		service.save(student);
		return student;
	}

    // Get all students from the h2 database.
    // @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping("/student")
    public List<StudentEntity> getAll() {
        return service.getAll();
    }
}
