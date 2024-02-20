package com.tickets.application.store.filter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.requests.TicketModelFilter;

import java.util.List;

/**
 * TicketFilter.
 * Public interface for tickets filtering.
 */
public interface TicketFilter {

    boolean isApplicable(TicketModelFilter ticketFilter);

    List<Ticket> apply(List<Ticket> tickets, TicketModelFilter ticketFilter);
}
