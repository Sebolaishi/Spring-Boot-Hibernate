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
     * @param personDto
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String savePerson(@Valid @RequestBody PersonDto personDto){
        Person person = convertToEntity(personDto);
        personService.save(person);
        return HttpStatus.CREATED.name();
    }

    /**
     *  Fetch all profiles associated to firstname
     * @param firstname for person
     * @return profiles associated to firstname
     */
    @GetMapping(value = "/{firstname}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PersonDto> findPersonByName(@PathVariable String firstname){
        List<PersonDto> personProfiles = new ArrayList<>();
        personService.findPersonByFirstname(firstname)
                .forEach(person -> {
                    PersonDto personDto = convertToDto(person);
                    personProfiles.add(personDto);
                });

        return personProfiles;
    }

    /**
     * Converts Dto to Entity
     * @param personDto for person object
     * @return person Object
     */
    @Override
    public Person convertToEntity(PersonDto personDto) {
        return modelMapper.map(personDto, Person.class);
    }

    /**
     * Converts entity to dto
     * @param person object
     * @return person dto
     */
    @Override
    public PersonDto convertToDto(Person person) {
        return modelMapper.map(person,PersonDto.class);
    }

}
