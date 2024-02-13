package com.tickets.application.user.controller;

import com.tickets.application.store.dao.TicketDao;
import com.tickets.application.user.dao.UserDao;
import com.tickets.application.user.service.UserProvider;
import com.tickets.application.user.service.UserRegistration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(value = UserController.USER_URL)
public class UserController {

    public final static String USER_URL= "/user";

    private final UserRegistration userRegistration;
    private final UserProvider userProvider;

    @PostMapping("/register")
    public ResponseEntity<UserDao> userRegistration(@RequestBody final UserDao userDao) {
        log.info("Request to save new user");
        final UserDao user = userRegistration.register(userDao);
        log.info("User {} was saved", userDao.getEmail());
        return ResponseEntity.ok()
                .body(user);
    }

    @GetMapping("/tickets/{userId}")
    public ResponseEntity<List<TicketDao>> getUserTickets(@PathVariable final UUID userId) {
        log.info("Request to get user's tickets");
        final List<TicketDao> tickets = userProvider.getUserTickets(userId);
        log.info("User tickets wos gotten");
        return ResponseEntity.ok()
                .body(tickets);
    }
}
