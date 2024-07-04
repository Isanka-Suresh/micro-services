package com.example.ticketservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class TicketServiceApplication {

	@Bean
	ModelMapper modelMapper(){ return new ModelMapper();}


	public static void main(String[] args) {
		SpringApplication.run(TicketServiceApplication.class, args);
	}

}
