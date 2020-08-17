package com.app.PetStoreApplication.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
