package com.boot.domain.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "Contact")
@NoArgsConstructor @Setter @Getter
public class Contact implements Serializable {

    /**
     * Contact entity properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Contact_Id", nullable = false, unique = true, updatable = false)
    private Long contact_Id;

    @Column(name = "Cell_Number", length = 30)
    private String cellNumber;

    @Email
    @Column(name = "Email_Address", length = 100)
    private String email;

    @JoinColumn(name = "Person_Id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;
}
