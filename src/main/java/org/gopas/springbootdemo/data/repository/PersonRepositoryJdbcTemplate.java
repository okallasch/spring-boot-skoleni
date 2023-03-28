package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PersonRepositoryJdbcTemplate {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepositoryJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_person as id, age, birthday, email, nickname, pwd FROM person p where p.id_person = ?",
                new BeanPropertyRowMapper<>(Person.class),
                id);
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT id_person as id, age, birthday, email, nickname, pwd from person p", new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Map<String, Object>> findMapAll() {
        return jdbcTemplate.queryForList("SELECT id_person as id, age, birthday, email, nickname, pwd from person p");
    }

    public void insert(Person person) {
        jdbcTemplate.update("INSERT INTO person (id_person, age, birthday, email, first_name, nickname, pwd, surname, id_address) VALUES (?,?,?,?,?,?,?,?,?)",
                person.getId(), person.getAge(), person.getBirthday(), person.getEmail(), "test", person.getNickname(), person.getPwd(), "test", 25L);
    }

    public void updateNickName(Person person) {
        Long id = person.getId();
        jdbcTemplate.update("UPDATE PERSON p set NICKNAME = ? WHERE p.id_person = ?", person.getNickname(), id);
    }

}
