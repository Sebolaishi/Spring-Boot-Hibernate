package com.boot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Setter @Getter @NoArgsConstructor
public class ContactDto {

    /**
     * Properties for Contact Dto
     */
    private String cellNumber;
    @Email
    private String email;

}
