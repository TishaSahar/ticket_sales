package com.tickets.application.user.service;

import com.tickets.application.store.converter.TicketConverter;
import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.model.Ticket;
import com.tickets.application.user.dao.UserDao;
import com.tickets.application.user.model.User;
import com.tickets.application.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * User provider.
 */
@Service
@RequiredArgsConstructor
public class UserProvider {

    private final UserRepository userRepository;
    private final TicketConverter ticketConverter;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<TicketDao> getUserTickets(final UUID userId) {
        final User user = getUserById(userId);
        final List<Ticket> tickets = user.getTickets();
        return ticketConverter.toTicketDaoList(tickets);
    }

    public User getUserById(final UUID userId) {
        return getUserOptionalById(userId)
                .orElseThrow(() ->new RuntimeException("Can't find user"));
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    private Optional<User> getUserOptionalById(final UUID userId) {
        return userRepository.findById(userId);
    }
}
