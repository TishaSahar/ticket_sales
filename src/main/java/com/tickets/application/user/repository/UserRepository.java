package com.tickets.application.user.repository;

import com.tickets.application.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Finds a user entity by its email.
     *
     * @param email The email of the user.
     * @return An optional containing the user entity if found.
     */
    Optional<User> findByEmail(String email);
}
