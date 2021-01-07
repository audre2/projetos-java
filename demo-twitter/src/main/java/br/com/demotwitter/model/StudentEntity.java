package br.com.demotwitter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class StudentEntity {

	@Id
	@GeneratedValue
	private int id;
	@Getter
	private String name;
	@Getter
	private int age;
	@Getter
	private String emailAddress;
}
