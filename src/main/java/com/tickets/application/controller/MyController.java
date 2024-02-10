package com.tickets.application.controller;

import com.tickets.application.datamodel.TicketDto;
import com.tickets.application.service.Service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/payment")
public class MyController {
    private final String sharedKey = "A_KEY";

    private static final String SUCCESS_STATUS = "SUCCESS";
    private static final String ERROR_STATUS = "ERROE";
    private static final int SUCCESS_RESPONSE = 200;
    private static final int SERVER_ERROR = 500;

    @GetMapping
    Service showStatus() {
        log.info("I love Olya!");
        return new Service(SUCCESS_STATUS, 1);
    }

    @PostMapping("/pay")
    public Service pay(@RequestParam(value = "key") String key, @RequestBody TicketDto request) {

        final Service response;

        if (sharedKey.equalsIgnoreCase(key)) {
            // int userId = request.getUserId();
            // String itemId = request.getItemId();
            
            // Success response to the client.
            response = new Service(SUCCESS_STATUS, SUCCESS_RESPONSE);
        } else {
            response = new Service(ERROR_STATUS, SERVER_ERROR);
        }
        return response;
    }
}