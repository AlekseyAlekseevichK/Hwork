package com.offsidegaming.monitoring.service.impl;

import com.offsidegaming.monitoring.model.User;
import com.offsidegaming.monitoring.repository.UserRepository;
import com.offsidegaming.monitoring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        deleteUserById(id);
    }
}
