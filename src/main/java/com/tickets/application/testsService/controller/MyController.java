package com.tickets.application.testsService.controller;

import com.tickets.application.testsService.dao.TicketDao;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> showStatus() {
        return ResponseEntity.ok()
                .body("");
    }

    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestParam(value = "key") String key, @RequestBody TicketDao request) {


        return ResponseEntity.ok()
                .body("");
    }
}