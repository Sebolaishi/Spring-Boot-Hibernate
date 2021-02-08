package com.boot;

import com.boot.domain.Person;
import com.boot.services.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonTests {

    Person person = new Person
            .PersonBuilder()
            .getFirstname("Mahlatse")
            .getLastname("Moloto")
            .getIdentityNumber("9303010000007")
            .getCreateDate(new Date())
            .getUpdateDate(new Date())
            .build();
    @Autowired
    private PersonService personService;

    @BeforeAll
    static void initializer(){

    }

    @Test
    public void testPerson(){

        Assert.assertNotNull(person.getFirstname());
        Assert.assertNotNull(person.getLastname());
        Assert.assertNotNull(person.getIdentityNumber());
        Assert.assertNotNull(person.getCreateDate());
        Assert.assertNotNull(person.getUpdateDate());
        personService.save(person);

    }
}
