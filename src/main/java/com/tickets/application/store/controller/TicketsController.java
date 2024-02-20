package com.tickets.application.store.controller;

import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.store.model.requests.TicketBuyRequest;
import com.tickets.application.store.model.requests.TicketModelFilter;
import com.tickets.application.store.service.TicketProvider;
import com.tickets.application.store.service.TicketStore;

import jakarta.persistence.Cacheable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller to the "tickets" get request.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(value = TicketsController.TICKETS_URL)
public class TicketsController {

    public final static String TICKETS_URL = "/tickets";

    private final TicketProvider ticketProvider;
    private final TicketStore ticketStore;

    /**
     * Mapping for the list of the tickets by filter.
     * 
     * @param ticketModelFilter
     * @return the list of TicketDao.
     */
    @CachePut(value = "ResponseEntity<List<TicketDao>>", key="#ticketModelFilter")
    @GetMapping
    public ResponseEntity<List<TicketDao>> getListOfTicketsByFilter(@RequestBody final TicketModelFilter ticketModelFilter) {
        log.info("Get request to list of free tickets by filters: {}", ticketModelFilter.toString());
        final List<TicketDao> tickets = ticketProvider.getListOfTicketsByFilter(ticketModelFilter);
        return ResponseEntity.ok().body(tickets);
    }

    /**
     * Mapping for ticket purchases.
     * 
     * @param ticketBuyRequest
     * @return TicketDao
     */
    @CacheEvict(value = "ResponseEntity<TicketDao>", allEntries = true)
    @PostMapping("/buy")
    public ResponseEntity<TicketDao> buyTicket(@RequestBody final TicketBuyRequest ticketBuyRequest) {
        log.info("Get request for buying ticket, for user with id: {}", ticketBuyRequest.getUserId());
        TicketDao ticket = new TicketDao();
        try {
            ticket = ticketStore.buyTicket(ticketBuyRequest);
        } catch (RuntimeException e) {
            log.info("This ticket is already bought. {}", e.getMessage());
        }
        log.info("Tickets has been bought success");
        return ResponseEntity.ok().body(ticket);
    }
}
