package com.boot.dto;

import com.boot.domain.system.AddressType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data @Setter @Getter
public class AddressDto {

    private AddressType address_Type;

    private String country;

    private Integer code;

}
