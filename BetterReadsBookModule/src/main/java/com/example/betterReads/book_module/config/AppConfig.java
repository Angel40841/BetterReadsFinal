package com.example.betterReads.book_module.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }
}
