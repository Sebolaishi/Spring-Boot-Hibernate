package com.boot.resources;

import com.boot.domain.system.Person;
import com.boot.dto.PersonDto;
import com.boot.services.PersonService;
import org.assertj.core.util.Preconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    private PersonService personService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Endpoint for creating new person record or object
     * @param resource
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String savePerson(@RequestBody PersonDto resource){
        Preconditions.checkNotNull(resource);
        Person person = modelMapper.map(resource, Person.class);
        personService.save(person);
        return HttpStatus.CREATED.name();
    }

    /**
     * Endpoint for fetching Person data by firstname
     * @param firstname
     * @return personProfiles
     */
    @GetMapping(value = "/{firstname}")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> findPersonByName(@PathVariable String firstname){
        List<PersonDto> personProfiles = new ArrayList<>();
        personService.findPersonByFirstname(firstname).forEach(person -> {
            PersonDto personDto = modelMapper.map(person,PersonDto.class);
            personProfiles.add(personDto);
        });

        return personProfiles;
    }

}
