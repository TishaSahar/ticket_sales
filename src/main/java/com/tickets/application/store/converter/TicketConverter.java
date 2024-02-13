package com.tickets.application.store.converter;

import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.model.Ticket;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface TicketConverter {

    @Mapping(target = "userId", source = "user", qualifiedByName = "userToUserId")
    @Mapping(target = "routeId", source = "route", qualifiedByName = "routeToRouteId")
    TicketDao toTicketDoa(final Ticket ticket);
}
