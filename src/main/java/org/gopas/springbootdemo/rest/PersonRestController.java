package org.gopas.springbootdemo.rest;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.gopas.springbootdemo.api.*;
import org.gopas.springbootdemo.data.model.Person;
import org.gopas.springbootdemo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/persons")
public class PersonRestController {

    Logger logger = LoggerFactory.getLogger(PersonRestController.class);

    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(path = "/{id}")
    public PersonDetailedViewDto findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }


    @GetMapping()
    public List<PersonBaseDto> findAll(){
        logger.info("GET LIST triggered ");
        List<PersonBaseDto> all = personService.findAll();
        logger.info("returning list: " + all);
        return all;
    }

    @GetMapping(path = "/pageable")
    public Page<PersonBaseDto> findPage(Pageable pageable) {
        logger.info("PageAble");
        return personService.findAllPageable(pageable);
    }

    @PostMapping
    public void createPerson(@RequestBody @Valid PersonCreateDto personCreateDto){
        logger.info("Create Person");
        personService.createPerson(personCreateDto);
    }


    @PutMapping
    public void updatePersonEmail(@RequestBody @Valid PersonUpdateDto personUpdateDto) {
        logger.info("Received object: " + personUpdateDto);
        personService.updatePerson(personUpdateDto);
    }



}
