package com.tickets.application.store.service;

import com.tickets.application.store.converter.TicketConverter;
import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.filter.TicketFilter;
import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.requests.TicketModelFilter;
import com.tickets.application.store.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketProvider {

    private final TicketRepository ticketRepository;
    private final TicketConverter ticketConverter;
    private final List<TicketFilter> ticketFilters;

    public List<TicketDao> getListOfTicketsByFilter(final TicketModelFilter ticketModelFilter) {
        List<Ticket> tickets = getAllTicketsEAGER();
        List<Ticket> availableTickets = tickets.stream()
                .filter(ticket -> ticket.getUser() == null)
                .toList();

        List<TicketFilter> availableFilters = ticketFilters.stream()
                .filter(ticketFilter -> ticketFilter.isApplicable(ticketModelFilter))
                .toList();

        for (TicketFilter filter : availableFilters) {
            availableTickets = filter.apply(availableTickets, ticketModelFilter);
        }

        return availableTickets.stream()
                .map(ticket -> ticketConverter.toTicketDoa(ticket))
                .toList();
    }

    //todo: make a custom filter, because so big request
    //here, i use entity graph request, because i need to solve N+1 problem
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    private List<Ticket> getAllTicketsEAGER() {
        return ticketRepository.findAllTicketsWithDetails();
    }

    public Ticket getTicketById(final UUID ticketId) {
        return getTicketOptionalById(ticketId)
                .orElseThrow(() -> new RuntimeException("Can't find ticket"));
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    private Optional<Ticket> getTicketOptionalById(final UUID ticketId) {
        return ticketRepository.findById(ticketId);
    }
}
