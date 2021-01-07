package br.com.demotwitter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.demotwitter.model.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer>{

}
