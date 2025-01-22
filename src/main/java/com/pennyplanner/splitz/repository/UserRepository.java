package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
