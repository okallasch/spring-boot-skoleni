package org.gopas.springbootdemo;

import org.gopas.springbootdemo.data.model.Address;
import org.gopas.springbootdemo.data.model.Person;
import org.gopas.springbootdemo.data.repository.PersonRepositoryJdbcTemplate;
import org.gopas.springbootdemo.service.AddressService;
import org.gopas.springbootdemo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication //stereotype anotace, component scan
public class SpringBootDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        PersonRepositoryJdbcTemplate personRepository = context.getBean(PersonRepositoryJdbcTemplate.class);
        PersonService personService = context.getBean(PersonService.class);
        AddressService addressService = context.getBean(AddressService.class);
        Person person = personService.findById(5L);
        logger.info("context.getBean: " + person);
/*
        final Person insertPerson = new Person();
        insertPerson.setId(999L);
        insertPerson.setAge(25);
        insertPerson.setBirthday(LocalDate.now());
        insertPerson.setPwd("TEST");
        insertPerson.setEmail("test@test.gopas");
        insertPerson.setNickname("test");
        personRepository.insert(insertPerson);

        System.out.println("FindAll: ");
        List<Person> all = personRepository.findAll();
        for (Person person1 : all) {
            System.out.println(person1);
        }
*/
        final Person personForUpdate = personService.findById(6L);
        logger.info("Person for Update is: " + personForUpdate);

        if (personForUpdate.getNickname().equalsIgnoreCase("updatednickname")) {
            personForUpdate.setNickname("Cyklista");
        } else {
            personForUpdate.setNickname("UpdatedNickName");
        }
        personService.save(personForUpdate);

        final Person updated = personRepository.findById(6L);
        logger.info("afterUpdate Person is: " + updated);

        Person forSave = new Person();

        Address address = addressService.findById(1L);


        forSave.setNickname("Test Save");
        forSave.setEmail("email@test.com");
        forSave.setAge(28);
        forSave.setBirthday(LocalDate.now());
        forSave.setPwd("hdushaugabfqweughjansd");
        forSave.setFirstName("Lukas");
        forSave.setSurname("Koklos");
        ;

        personService.save(forSave);


        personService.save(forSave);
/*
        System.out.println("FindAll Mapa:");

        List<Map<String, Object>> mapAll = personRepository.findMapAll();
        for (Map<String, Object> stringObjectMap : mapAll) {
            System.out.println(stringObjectMap);
        }

 */
    }

}
