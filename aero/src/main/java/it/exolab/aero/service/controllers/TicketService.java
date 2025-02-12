package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.airport_01Model.models.entities.Ticket;
import it.exolab.aero.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);

        return ticket.get();
    }
}
