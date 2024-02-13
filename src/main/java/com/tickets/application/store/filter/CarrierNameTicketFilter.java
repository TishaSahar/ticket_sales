package com.tickets.application.store.filter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.TicketModelFilter;

import java.util.List;

public class CarrierNameTicketFilter implements TicketFilter {

    @Override
    public boolean isApplicable(TicketModelFilter ticketFilter) {
        return ticketFilter.getCarrierName() != null;
    }

    @Override
    public void apply(List<Ticket> tickets, TicketModelFilter ticketFilter) {
        tickets.removeIf(ticket -> {
            final String carrierName = ticket.getRoute().getCarrier().getName();
            final String expectCarrierName = ticketFilter.getCarrierName();
            return !carrierName.equals(expectCarrierName);
        });
    }
}
