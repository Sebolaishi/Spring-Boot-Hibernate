package com.boot;

import com.boot.domain.system.Person;
import com.boot.services.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PersonTests {

    @Autowired
    private PersonService personService;

    /**
     * Prepare Object testing data
     */
    Person person = new Person
            .PersonBuilder()
            .getFirstname("Mahlatse")
            .getLastname("Moloto")
            .getIdentityNumber("9303010000007")
            .getCreateDate(LocalDateTime.now())
            .getUpdateDate(LocalDateTime.now())
            .build();
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void initializer(){

    }

    /**
     * Testing Person object and properties nullity
     */
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
