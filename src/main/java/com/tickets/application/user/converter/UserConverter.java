package com.tickets.application.user.converter;

import com.tickets.application.store.model.Ticket;
import com.tickets.application.user.dao.UserDao;
import com.tickets.application.user.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface UserConverter {

    @Mapping(target = "ticketIds", source = "tickets", qualifiedByName = "ticketsToTicketIds")
    UserDao toUserDao(final User user);

    @Mapping(target = "tickets", source = "ticketIds", ignore = true)
    User toUser(final UserDao userDao);

    @Named("ticketsToTicketIds")
    default List<UUID> ticketsToTicketIds(List<Ticket> tickets) {
        return tickets == null ?
                new ArrayList<>() :
                tickets.stream().map(Ticket::getId).toList();
    }
}
