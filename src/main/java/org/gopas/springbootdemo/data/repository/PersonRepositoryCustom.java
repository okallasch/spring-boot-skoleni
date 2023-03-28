package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepositoryCustom {


    Optional<Person> findByIdWithAddress(Long id);
}
