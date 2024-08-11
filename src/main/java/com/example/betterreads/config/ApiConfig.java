package com.example.betterreads.config;

import com.example.betterreads.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.client.RestClient;

import javax.sql.DataSource;

@Configuration
public class ApiConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public RestClient restClient(BookModuleApiConfig config) {
//        return RestClient.builder()
//                .baseUrl(config.getBaseUrl())
//                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
//                .build();
//    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(
            DataSource dataSource,
            UserRoleRepository roleRepository,
            ResourceLoader resourceLoader) {

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);

        if (roleRepository.count() == 0) {
            ResourceDatabasePopulator populate = new ResourceDatabasePopulator();
            populate.addScript(resourceLoader.getResource("classpath:data.sql"));
            initializer.setDatabasePopulator(populate);
        }

        return initializer;
    }

}
