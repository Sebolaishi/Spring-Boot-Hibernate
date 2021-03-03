package com.boot.services;

import com.boot.domain.system.Person;
import com.boot.dto.PersonDto;
import com.boot.repository.PersonRepository;
import com.boot.services.modelMapper.ConversionToDto;
import com.boot.services.modelMapper.ConversionToEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PersonService implements ConversionToEntity<Person, PersonDto>, ConversionToDto<PersonDto,Person>, Serializable{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     *
     * @param person
     * @return
     */
    public void save(Person person){
        person.getAddresses().forEach(address -> address.setPerson(person));
        person.getContacts().forEach(contact -> contact.setPerson(person));
        personRepository.save(person);
    }

    /**
     * Fetch person data by person firstname
     * @param firstname
     * @return
     */
    public List<Person> findPersonByFirstname(String firstname){
        return personRepository.findPersonByFirstname(firstname);
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
