package com.boot.services;

import com.boot.domain.Person;
import com.boot.resources.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PersonService implements Serializable{

    @Autowired
    private PersonRepository personRepository;

    public void save(Person person){
        personRepository.save(person);
    }
}
