package com.tickets.application.store.filter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.TicketModelFilter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeparturePointTicketFilter implements TicketFilter {

    @Override
    public boolean isApplicable(TicketModelFilter ticketFilter) {
        return ticketFilter.getDeparturePoint() != null;
    }

    @Override
    public List<Ticket> apply(List<Ticket> tickets, TicketModelFilter ticketFilter) {
        return tickets.stream()
                .filter(ticket -> {
                    final String departurePoint = ticket.getRoute().getDeparturePoint();
                    final String expectDeparturePoint = ticketFilter.getDeparturePoint();
                    return departurePoint.equals(expectDeparturePoint);
                }).toList();
    }
}
