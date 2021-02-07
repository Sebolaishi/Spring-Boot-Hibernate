package com.boot;

import com.boot.domain.Person;
import com.boot.services.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonTests {

    Person.PersonBuilder personBuilder = Person.PersonBuilder.builder()
            .firstname("Mahlatse")
            .lastname("Moloto")
            .identityNumber("9303010000008")
            .build();

    Person person = new Person();

    @Autowired
    private PersonService personService;

    @Test
    public void testPerson(){

        person.setFirstname("Mahlatse");
        person.setLastname("Moloto");
        person.setIdentityNumber("9303015785089");
        person.setUpdateDate(new Date());
        person.setCreateDate(new Date());

        Assert.assertNotNull(person);

        personService.save(person);

    }
}
