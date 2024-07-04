package com.example.ticketservice.controller;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/healthchk")
    public String healthchk(){
        return "Ticket Service Running";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> saveUser(@RequestBody TicketDTO ticketDTO){
        try {
            TicketDTO ticket = ticketService.saveTicket(ticketDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> updateUser(@RequestBody TicketDTO ticketDTO){
        try {
            TicketDTO ticket = ticketService.updateTicket(ticketDTO);
            return ResponseEntity.status(HttpStatus.OK).body(ticket);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> getUser(@PathVariable("id") String id){
        try {
            TicketDTO ticketDTO = ticketService.getSelectedTicket(id);
            return ResponseEntity.status(HttpStatus.OK).body(ticketDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TicketDTO>> getAllUsers(){
        try {
            List<TicketDTO> ticketDTOS = ticketService.getAllTickets();
            return ResponseEntity.status(HttpStatus.OK).body(ticketDTOS);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
