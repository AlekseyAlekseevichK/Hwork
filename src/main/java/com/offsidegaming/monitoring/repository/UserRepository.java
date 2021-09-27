package com.offsidegaming.monitoring.repository;

import com.offsidegaming.monitoring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
