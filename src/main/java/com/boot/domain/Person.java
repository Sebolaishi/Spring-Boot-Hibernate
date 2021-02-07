package com.boot.domain;

import com.boot.domain.base.CoreBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Person")
@RequiredArgsConstructor @Setter
public class Person extends CoreBaseEntity implements Serializable {

    @Column(name = "FirstName", length = 30)
    private String firstname;

    @Column(name = "LastName", length = 30)
    private String lastname;

    @Column(name = "IdentityNumber", length = 13)
    private String identityNumber;

    @Builder
    public static class PersonBuilder{
        private final String firstname;
        private final String lastname;
        private final String identityNumber;
        protected Date createDate;
        protected Date updateDate;

    }


}
