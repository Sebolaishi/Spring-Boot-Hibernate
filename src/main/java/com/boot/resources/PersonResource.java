package com.boot.resources;

import com.boot.domain.system.Person;
import com.boot.dto.PersonDto;
import com.boot.services.modelMapper.ConversionToDto;
import com.boot.services.modelMapper.ConversionToEntity;
import com.boot.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource implements ConversionToEntity<Person, PersonDto>, ConversionToDto<PersonDto,Person> {

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
    @ResponseBody
    public String savePerson(@Valid @RequestBody PersonDto resource){
        Person person = modelMapper.map(resource, Person.class);
        personService.save(person);
        return HttpStatus.CREATED.name();
    }

    /**
     *
     * @param firstname person firstname
     * @return profiles associated to firstname
     */
    @GetMapping(value = "/{firstname}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PersonDto> findPersonByName(@PathVariable String firstname){
        List<PersonDto> personProfiles = new ArrayList<>();
        personService.findPersonByFirstname(firstname).forEach(person -> {
            PersonDto personDto = convertToDto(person);
            personProfiles.add(personDto);
        });

        return personProfiles;
    }

    @Override
    public Person convertToEntity(PersonDto objectDto) {
        return modelMapper.map(objectDto, Person.class);
    }

    @Override
    public PersonDto convertToDto(Person object) {
        return modelMapper.map(object,PersonDto.class);
    }

}
