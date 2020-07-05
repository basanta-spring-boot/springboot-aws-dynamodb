package com.javatechie.aws;

import com.javatechie.aws.entity.Professor;
import com.javatechie.aws.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootAwsDynamodbApplication {
    @Autowired
    private ProfessorRepository repository;

    @PostMapping("/save")
    public String saveProfessor(@RequestBody Professor professor) {
        return repository.saveProfessorInfo(professor);
    }

    @GetMapping("/professor/{professorId}")
    public Professor findProfessor(@PathVariable String professorId) {
        return repository.findProfessor(professorId);
    }

    @PutMapping("/edit")
    public String editProfessor(@RequestBody Professor professor){
    	   return repository.editProfessorInfo(professor);
	}

	@DeleteMapping("/remove")
	public String deleteProfessor(@RequestBody Professor professor) {
    	return repository.removeProfessor(professor);
	}

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsDynamodbApplication.class, args);
    }

}
