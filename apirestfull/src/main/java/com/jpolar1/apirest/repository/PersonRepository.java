package com.jpolar1.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpolar1.apirest.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}