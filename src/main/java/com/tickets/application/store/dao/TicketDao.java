package com.tickets.application.store.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Ticket data access object.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDao {

    private UUID id;

    private UUID userId;

    private UUID routeId;

    private OffsetDateTime dateTime;

    private Integer passNumber;

    private Integer price;
}
