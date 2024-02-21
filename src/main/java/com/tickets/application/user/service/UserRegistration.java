package com.tickets.application.user.service;

import com.tickets.application.user.converter.UserConverter;
import com.tickets.application.user.dao.UserDao;
import com.tickets.application.user.model.User;
import com.tickets.application.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User registration.
 */
@Service
@RequiredArgsConstructor
public class UserRegistration {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public UserDao register(final UserDao userDao) {
        final User user = userConverter.toUser(userDao);
        final User savedUser = userRepository.save(user);
        return userConverter.toUserDao(savedUser);
    }
}
