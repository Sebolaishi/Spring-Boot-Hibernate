package com.boot.resources;

import com.boot.domain.system.Person;
import com.boot.services.PersonService;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Person savePerson(@RequestBody Person resource){
        Preconditions.checkNotNull(resource);
        return personService.save(resource);
    }


}
