package com.tickets.application.store.filter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.TicketModelFilter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeTicketFromFilter implements TicketFilter{
    @Override
    public boolean isApplicable(TicketModelFilter ticketFilter) {
        return ticketFilter.getDateTimeFrom() != null;
    }

    @Override
    public void apply(List<Ticket> tickets, TicketModelFilter ticketFilter) {
         tickets.removeIf(ticket -> ticket.getDateTime().isBefore(ticketFilter.getDateTimeFrom()));
    }
}
