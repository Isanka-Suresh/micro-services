package com.example.paymentservice.controller;

import com.example.paymentservice.dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/pay")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/healthchk")
    public String healthchk(){
        //return "Payment Service Running";
        return restTemplate.getForObject("http://ticket-service/app/api/v1/ticket/healthchk",String.class);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> getTicket(@PathVariable("id") String id){
        System.out.println("get method");
        return restTemplate.getForEntity("http://ticket-service/app/api/v1/ticket/"+id, TicketDTO.class);
    }

    @PutMapping
    public TicketDTO updateStatus(@RequestBody TicketDTO ticketDTO){
        return restTemplate.postForObject("http://ticket-service/app/api/v1/ticket", ticketDTO, TicketDTO.class);
    }
}
