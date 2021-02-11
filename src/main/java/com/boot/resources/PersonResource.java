package com.boot.resources;

import com.boot.domain.system.Person;
import com.boot.services.PersonService;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    /**
     * Endpoint for creating new person record or object
     * @param resource
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String savePerson(@RequestBody Person resource){
        Preconditions.checkNotNull(resource);
        return HttpStatus.CREATED.name();
    }

    /**
     * Endpoint for fetching Person data by name
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findPersonByName(@RequestParam String name){
        return personService.findByName(name);
    }

}
