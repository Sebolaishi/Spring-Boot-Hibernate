package com.boot.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class ContactDto {

    /**
     * Properties for Contact Dto
     */
    private String cellNumber;
    @Email
    private String email;

}
