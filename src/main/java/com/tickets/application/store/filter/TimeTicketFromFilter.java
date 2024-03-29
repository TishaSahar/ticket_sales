package com.tickets.application.store.filter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.requests.TicketModelFilter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Time ticket filter.
 */
@Component
public class TimeTicketFromFilter implements TicketFilter {
    @Override
    public boolean isApplicable(TicketModelFilter ticketFilter) {
        return ticketFilter.getDateTimeFrom() != null;
    }

    @Override
    public List<Ticket> apply(List<Ticket> tickets, TicketModelFilter ticketFilter) {
        return tickets.stream()
                .filter(ticket -> ticket.getDateTime().isAfter(ticketFilter.getDateTimeFrom()))
                .toList();
    }
}
