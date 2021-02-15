package com.boot.repository;

import com.boot.domain.system.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     *
     * @param firstname for person
     * @return
     */
    List<Person> findPersonByFirstname(String firstname);
}
