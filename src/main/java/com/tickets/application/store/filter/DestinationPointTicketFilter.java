package com.tickets.application.store.filter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.requests.TicketModelFilter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DestinationPointTicketFilter.
 * Implements tickets filtering.
 */
@Component
public class DestinationPointTicketFilter implements TicketFilter {

    @Override
    public boolean isApplicable(TicketModelFilter ticketFilter) {
        return ticketFilter.getDestinationPoint() != null;
    }

    @Override
    public List<Ticket> apply(List<Ticket> tickets, TicketModelFilter ticketFilter) {
        return tickets.stream()
                .filter(ticket -> {
                    final String destinationPoint = ticket.getRoute().getDestinationPoint();
                    final String expectDestinationPoint = ticketFilter.getDeparturePoint();
                    return destinationPoint.equals(expectDestinationPoint);
                }).toList();
    }
}
