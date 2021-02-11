package com.boot.services;

import com.boot.domain.system.Person;
import com.boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PersonService implements Serializable{

    @Autowired
    private PersonRepository personRepository;

    /**
     *
     * @param person
     * @return
     */
    public Person save(Person person){
        return personRepository.save(person);
    }

    /**
     * Fetch person data by person firstname
     * @param firstname
     * @return
     */
    public List<Person> findPersonByFirstname(String firstname){
        return personRepository.findPersonByFirstname(firstname);
    }
}
