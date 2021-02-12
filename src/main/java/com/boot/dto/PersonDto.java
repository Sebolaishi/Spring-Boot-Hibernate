package com.boot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter @Getter
public class PersonDto {
    private String firstname;
    private String lastname;
    private String identityNumber;
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();
}
