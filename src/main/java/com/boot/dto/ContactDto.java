package com.boot.dto;

import com.boot.domain.system.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;

@Component
@Data @Setter @Getter
public class ContactDto {

    private String cellNumber;

    @Email
    private String email;

}
