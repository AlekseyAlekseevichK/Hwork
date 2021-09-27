package com.offsidegaming.monitoring.service;

import com.offsidegaming.monitoring.model.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findUser(Long id);

    void deleteUserById(Long id);

}
