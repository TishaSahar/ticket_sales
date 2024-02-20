package com.tickets.application.store.service;

import com.tickets.application.store.converter.TicketConverter;
import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.model.Ticket;
import com.tickets.application.store.model.requests.TicketBuyRequest;
import com.tickets.application.user.model.User;
import com.tickets.application.user.service.UserProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Ticket store service.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TicketStore {

    private final TicketProvider ticketProvider;
    private final UserProvider userProvider;
    private final TicketConverter ticketConverter;

    @Cacheable(value = "TicketDao", key="#Propagation.REQUIRED")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public TicketDao buyTicket(final TicketBuyRequest ticketBuyRequest) {
        final UUID userId = ticketBuyRequest.getUserId();
        final UUID ticketId = ticketBuyRequest.getTicketId();

        final User user = userProvider.getUserById(userId);
        final Ticket ticket = ticketProvider.getTicketById(ticketId);

        if (ticket.getUser() != null) {
            log.info("Ticket has  already bought");
            return new TicketDao();
        }

        ticket.setUser(user);
        return ticketConverter.toTicketDao(ticket);
    }
}
