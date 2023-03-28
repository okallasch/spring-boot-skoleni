package org.gopas.springbootdemo.service;

import org.gopas.springbootdemo.data.model.Person;
import org.gopas.springbootdemo.data.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonService {


    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
       return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person with id: " + id + " not found"));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }
}
