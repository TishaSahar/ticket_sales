package com.tickets.application.store.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDao {

    private UUID id;

    private UUID carrierId;

    private String departurePoint;

    private String destinationPoint;

    private Integer durationMinutes;

    private Integer capacity;
}
