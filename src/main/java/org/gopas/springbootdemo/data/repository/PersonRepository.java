package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
