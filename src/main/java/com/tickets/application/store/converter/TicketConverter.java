package com.tickets.application.store.converter;

import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.model.Route;
import com.tickets.application.store.model.Ticket;
import com.tickets.application.user.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

/**
 * Construct ticket data access object.
 */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface TicketConverter {

    @Mapping(target = "userId", source = "user", qualifiedByName = "userToUserId")
    @Mapping(target = "routeId", source = "route", qualifiedByName = "routeToRouteId")
    TicketDao toTicketDao(final Ticket ticket);

    List<TicketDao> toTicketDaoList(final List<Ticket> tickets);

    /**
     * Convert user to user id.
     * 
     * @param user the user
     * @return user UUID
     */
    @Named("userToUserId")
    default UUID userToUserId(User user) {
        return user == null ? null : user.getId();
    }

    /**
     * Convert route to the route id.
     * 
     * @param route the route
     * @return rout UUID
     */
    @Named("routeToRouteId")
    default UUID routeToRouteId(Route route) {
        return route == null ? null : route.getId();
    }
}
