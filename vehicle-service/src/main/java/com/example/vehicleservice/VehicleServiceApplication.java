package com.example.vehicleservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class VehicleServiceApplication {

    @Bean
    ModelMapper modelMapper(){ return new ModelMapper();}


    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
    }

}
