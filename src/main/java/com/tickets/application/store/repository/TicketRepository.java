package com.tickets.application.store.repository;

import com.tickets.application.store.model.Ticket;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    @Query("SELECT t FROM Ticket t")
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"route", "route.carrier"})
    List<Ticket> findAllTicketsWithDetails();

}
