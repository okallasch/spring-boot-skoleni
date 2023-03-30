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
    }
}
