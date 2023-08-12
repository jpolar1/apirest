package com.jpolar1.apirest.service;

import java.util.List;

import com.jpolar1.apirest.entity.Person;

public interface PersonService {
	
	public List<Person> findAll();
	public Person findById(Long id);
	public Person create(Person person);
	public Person update(Person person);
	public void delete(Long id);

}
