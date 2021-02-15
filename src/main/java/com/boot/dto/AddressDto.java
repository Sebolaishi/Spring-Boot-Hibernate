package com.boot.dto;

import com.boot.domain.system.AddressType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter @Getter @NoArgsConstructor
public class AddressDto {

    /**
     * Properties for Address Dto
     */
    private AddressType address_Type;
    private String country;
    private Integer code;

}
