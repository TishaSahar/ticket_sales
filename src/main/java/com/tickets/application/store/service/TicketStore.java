package com.tickets.application.store.service;

import com.tickets.application.store.converter.TicketConverter;
import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.requests.TicketBuyRequest;
import com.tickets.application.user.model.User;
import com.tickets.application.user.service.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class TicketStore {

    private final TicketProvider ticketProvider;
    private final UserProvider userProvider;
    private final TicketConverter ticketConverter;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public TicketDao buyTicket(final TicketBuyRequest ticketBuyRequest) {
        final UUID userId = ticketBuyRequest.getUserId();
        final UUID ticketId = ticketBuyRequest.getTicketId();

        final User user = userProvider.getUserById(userId);
        final Ticket ticket = ticketProvider.getTicketById(ticketId);

        if (ticket.getUser() != null) {
            throw new RuntimeException("Ticket has  already bought");
        }

        ticket.setUser(user);
        return ticketConverter.toTicketDoa(ticket);
    }
}
