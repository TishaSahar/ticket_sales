package com.tickets.application.store.controller;

import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.model.TicketModelFilter;
import com.tickets.application.store.service.TicketProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(value = TicketsController.TICKETS_URL)
public class TicketsController {

    public final static String TICKETS_URL = "/tickets";

    private final TicketProvider ticketProvider;

    @GetMapping
    public ResponseEntity<List<TicketDao>> getListOfTicketsByFilter(@RequestBody final TicketModelFilter ticketModelFilter) {
        log.info("Get request to list of free tickets by filters");
        final List<TicketDao> tickets = ticketProvider.getListOfTicketsByFilter(ticketModelFilter);
        log.info("Tickets was gotten success");
        return ResponseEntity.ok()
                .body(tickets);
    }
}
