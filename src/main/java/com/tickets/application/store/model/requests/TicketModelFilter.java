package com.tickets.application.store.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketModelFilter {

    @NotNull
    private Integer page;

    private OffsetDateTime dateTimeFrom;

    private String departurePoint;

    private String destinationPoint;

    private String carrierName;
}