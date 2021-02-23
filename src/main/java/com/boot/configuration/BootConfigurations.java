package com.boot.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfigurations {

    /**
     * Model Mapper configuration bean.
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
