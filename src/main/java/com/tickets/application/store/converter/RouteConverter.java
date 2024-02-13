package com.tickets.application.store.converter;

import com.tickets.application.store.model.Route;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface RouteConverter {

    @Named("routeToRouteId")
    default UUID routeToRouteId(Route route) {
        return route.getId();
    }
}
