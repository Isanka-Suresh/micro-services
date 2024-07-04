package com.example.ticketservice.service;

import com.example.ticketservice.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO saveTicket(TicketDTO ticketDTO);
    void deleteTicket(String ticketId);
    TicketDTO getSelectedTicket(String ticketId);
    List<TicketDTO> getAllTickets();
    TicketDTO updateTicket(TicketDTO ticketDTO);
}
