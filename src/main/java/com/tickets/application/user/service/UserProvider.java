package com.tickets.application.user.service;

import com.tickets.application.user.model.User;
import com.tickets.application.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProvider {

    private final UserRepository userRepository;

    public User getUserById(final UUID userId) {
        return getUserOptionalById(userId)
                .orElseThrow(() ->new RuntimeException("Can't find user"));
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    private Optional<User> getUserOptionalById(final UUID userId) {
        return userRepository.findById(userId);
    }
}
