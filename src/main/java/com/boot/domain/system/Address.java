package com.boot.domain.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
@NoArgsConstructor @Setter @Getter @ToString
public class Address implements Serializable {

    /**
     * Address entity properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_Id", nullable = false, unique = true, updatable = false)
    private Long address_Id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Address_Type", length = 50)
    private AddressType address_Type;

    @Column(name = "Country", length = 50)
    private String country;

    @Column(name = "Code")
    private Integer code;

    /**
     * Address object builder
     */
    public static class AddressBuilder{
        private AddressType address_Type;
        private String country;
        private Integer code;

        public AddressBuilder addressType(AddressType address_Type){
            this.address_Type = address_Type;
            return this;
        }

        public AddressBuilder withCountry(String country){
            this.country = country;
            return this;
        }

        public AddressBuilder withCode(Integer code){
            this.code = code;
            return this;
        }

        public Address build(){
            Address address = new Address();
            address.address_Type = address_Type;
            address.country = country;
            address.code = code;

            return address;
        }

    }

}
