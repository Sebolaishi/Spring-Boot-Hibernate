package com.boot.repository;

import com.boot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     *
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends Person> S save(S s);
}