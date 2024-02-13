package com.tickets.application.user.controller;

import com.tickets.application.user.dao.UserDao;
import com.tickets.application.user.service.UserRegistration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(value = UserController.USER_URL)
public class UserController {

    public final static String USER_URL= "authenticate";

    private final UserRegistration userRegistration;

    @PostMapping("/register")
    public ResponseEntity<?> userRegistration(@RequestBody final UserDao userDao) {
        log.info("Request to save new user");
        UserDao response = userRegistration.register(userDao);
        log.info("User {} was saved", userDao.getEmail());
        return ResponseEntity.ok()
                .body(response);
    }
}
