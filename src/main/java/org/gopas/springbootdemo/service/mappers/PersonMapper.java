package org.gopas.springbootdemo.service.mappers;

import org.gopas.springbootdemo.api.*;
import org.gopas.springbootdemo.data.model.Person;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDetailedViewDto mapDetailDto (Person person);

    List<PersonBaseDto> mapBaseDto (List<Person> person);

    PersonBaseDto mapBaseDto(Person person);

    default Page<PersonBaseDto> mapPageBaseDto(Page<Person> page) {
        return page.map(this::mapBaseDto);
    }

    Person mapPersonCreateDto(PersonCreateDto personCreateDto);

    Person mapPersonUpdateDto(PersonUpdateDto personUpdateDto);
}
