package com.boot.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PersonDto {

    /**
     * properties for Person Dto
     */
    @NotBlank(message = "FirstName is required")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    private String lastname;
    @NotBlank(message = "ID Number is required")
    private String identityNumber;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    private List<ContactDto> contacts;
    private List<AddressDto> addresses;

}
