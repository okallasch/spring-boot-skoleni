package org.gopas.springbootdemo.service;

import org.gopas.springbootdemo.api.PersonBaseDto;
import org.gopas.springbootdemo.api.PersonCreateDto;
import org.gopas.springbootdemo.api.PersonDetailedViewDto;
import org.gopas.springbootdemo.api.PersonUpdateDto;
import org.gopas.springbootdemo.data.model.Person;
import org.gopas.springbootdemo.data.repository.PersonRepository;
import org.gopas.springbootdemo.exceptions.CreatePersonException;
import org.gopas.springbootdemo.exceptions.ResourceNotFoundEception;
import org.gopas.springbootdemo.exceptions.UpdatePersonException;
import org.gopas.springbootdemo.service.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {


    private PersonRepository personRepository;

    private PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }


    @Transactional()
    @PostAuthorize("returnObject.email == authentication.name")
    public PersonDetailedViewDto findById(Long id) {
            Person person = personRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundEception("Person with id: " + id + " not found"));
            return personMapper.mapDetailDto(person);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PersonBaseDto> findAll() {
        List<Person> all = personRepository.findAll();
        return personMapper.mapBaseDto(all);
    }

    public Page<PersonBaseDto> findAllPageable(Pageable pageable) {
        Page<Person> all = personRepository.findAll(pageable);
        return personMapper.mapPageBaseDto(all);
    }

    public void createPerson(PersonCreateDto personCreateDto) {
        try {
            Person person = personMapper.mapPersonCreateDto(personCreateDto);
            personRepository.save(person);
        } catch (DataAccessException e) {
            throw new CreatePersonException("Došlo k chybě při ukládání uživatele do DB" + personCreateDto.getSurname(), e);
        }
    }

    public void updatePerson(PersonUpdateDto personUpdateDto) {
        try {
            Person person = personMapper.mapPersonUpdateDto(personUpdateDto);
            personRepository.save(person);
        } catch (DataAccessException e) {
            throw new UpdatePersonException("Došlo k chybě při aktualizaci uživatele do DB" + personUpdateDto.getFirstName(), e);
        }
    }
}
