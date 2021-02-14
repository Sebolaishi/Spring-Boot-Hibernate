package com.boot;

import com.boot.domain.system.Address;
import com.boot.domain.system.AddressType;
import com.boot.domain.system.Contact;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PersonTests {

    @Autowired
    private PersonService personService;
    private Person person;
    private List<Address> addresses = new ArrayList<>();
    private List<Contact> contacts = new ArrayList<>();

    /**
     * Prepare Object testing data
     */

    private void initializer(){
        Contact contact = new Contact();
        person = new Person
                .PersonBuilder()
                .getFirstname("Mahlatse")
                .getLastname("Moloto")
                .getIdentityNumber("9303010000007")
                .getCreateDate(LocalDateTime.now())
                .getUpdateDate(LocalDateTime.now())
                .build();

        Address address = new Address
                .AddressBuilder()
                .addressType(AddressType.PHYSICAL)
                .withCountry("South Africa")
                .withCode(0700)
                .build();

        contact.setCellNumber("0700000000");
        contact.setEmail("molotolodwin@gmail.com");
        contacts.add(contact);
        contact.setPerson(person);
        person.setContacts(contacts);

        addresses.add(address);
        address.setPerson(person);
        person.setAddresses(addresses);

    }

    /**
     * Testing Person object and properties nullity
     */
    @Test
    public void testPersonDetails(){
        initializer();

        Assert.assertNotNull(person.getFirstname());
        Assert.assertNotNull(person.getLastname());
        Assert.assertNotNull(person.getIdentityNumber());
        Assert.assertFalse(person.getAddresses().isEmpty());
        Assert.assertNotNull(person.getCreateDate());
        Assert.assertNotNull(person.getUpdateDate());
        //personService.save(person);

    }


    }
