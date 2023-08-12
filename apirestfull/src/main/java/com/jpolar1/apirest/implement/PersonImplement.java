package com.jpolar1.apirest.implement;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpolar1.apirest.entity.Person;
import com.jpolar1.apirest.exceptions.ResourceNotFoundException;
import com.jpolar1.apirest.repository.PersonRepository;
import com.jpolar1.apirest.service.PersonService;

@Service
public class PersonImplement implements PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	PersonRepository repository;

	@Transactional(readOnly = true)
	@Override
	public List<Person> findAll() {

		logger.info("Finding all people!");

		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Person findById(Long id) {

		logger.info("Finding one person!");

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}

	@Transactional
	@Override
	public Person create(Person person) {

		logger.info("Creating one person!");

		return repository.save(person);
	}

	@Transactional
	@Override
	public Person update(Person person) {

		logger.info("Updating one person!");

		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(person);
	}

	@Transactional
	@Override
	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

}
