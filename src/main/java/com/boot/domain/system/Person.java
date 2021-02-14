package com.boot.domain.system;

import com.boot.domain.base.CoreBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
@NoArgsConstructor @Setter @Getter
public class Person extends CoreBaseEntity implements Serializable {

    /**
     * Person entity properties
     */
    @Column(name = "FirstName", length = 30)
    private String firstname;

    @Column(name = "LastName", length = 30)
    private String lastname;

    @Column(name = "IdentityNumber", length = 13)
    private String identityNumber;

    /**
     * Entity relationships association
     */
    @OneToMany(mappedBy = "address_Id", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    private List<Address> addresses = new ArrayList<>();

    @OneToMany( mappedBy = "contact_Id", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    private List<Contact> contacts = new ArrayList<>();

    /**
     * Building Person object.
     */
    public static class PersonBuilder{
        private String firstname;
        private String lastname;
        private String identityNumber;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;

        public PersonBuilder getFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public PersonBuilder getLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public PersonBuilder getIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
            return this;
        }

        public PersonBuilder getCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public PersonBuilder getUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Person build(){
            Person person = new Person();

            person.firstname = this.firstname;
            person.lastname = this.lastname;
            person.identityNumber = this.identityNumber;
            person.createDate = this.createDate;
            person.updateDate = this.updateDate;

            return person;
        }
    }


}
