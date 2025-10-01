package com.devfreelahub.repositories;

import com.devfreelahub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional; // Make sure this import exists

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ THIS IS THE MISSING METHOD DECLARATION
    // By adding this line, Spring Data JPA will automatically create the implementation for you.
    Optional<User> findByEmail(String email);
}