package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<Person> findByIdWithAddress(Long id) {
        TypedQuery<Person> person = entityManager.createQuery("SELECT p FROM Person p JOIN Address a on a.id = p.id WHERE p.id = :id", Person.class)
                .setParameter("id", id);
        return Optional.ofNullable(person.getSingleResult());
    }
}
