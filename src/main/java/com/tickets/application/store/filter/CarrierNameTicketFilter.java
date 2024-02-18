package com.tickets.application.store.filter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.requests.TicketModelFilter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Carrier name ticket filter.
 */
@Component
public class CarrierNameTicketFilter implements TicketFilter {

    @Override
    public boolean isApplicable(TicketModelFilter ticketFilter) {
        return ticketFilter.getCarrierName() != null;
    }

    @Override
    public List<Ticket> apply(List<Ticket> tickets, TicketModelFilter ticketFilter) {
        return tickets.stream()
                .filter(ticket -> {
                    final String carrierName = ticket.getRoute().getCarrier().getName();
                    final String expectCarrierName = ticketFilter.getCarrierName();
                    return carrierName.equals(expectCarrierName);
                }).toList();
    }
}
