package com.tickets.application.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketModelFilter {

    private OffsetDateTime dateTimeFrom;

    private String departurePoint;

    private String destinationPoint;

    private String carrierName;
}