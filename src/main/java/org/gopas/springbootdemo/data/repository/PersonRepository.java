package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p LEFT JOIN FETCH p.personHasRoleSet phr LEFT JOIN FETCH phr.idRole r " +
            "WHERE p.email = :email")
    Person findByEmail(@Param(value = "email") String email);



}
