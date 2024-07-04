package com.example.ticketservice.service.impl;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.entity.Ticket;
import com.example.ticketservice.repo.TicketRepo;
import com.example.ticketservice.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        return modelMapper.map(ticketRepo.save(modelMapper.map(ticketDTO, Ticket.class)), TicketDTO.class);
    }

    @Override
    public void deleteTicket(String ticketId) {

    }

    @Override
    public TicketDTO getSelectedTicket(String ticketId) {
        return modelMapper.map(ticketRepo.findById(ticketId), TicketDTO.class);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return modelMapper.map(ticketRepo.findAll(), List.class);
    }

    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        return modelMapper.map(ticketRepo.save(modelMapper.map(ticketDTO, Ticket.class)), TicketDTO.class);
    }
}
