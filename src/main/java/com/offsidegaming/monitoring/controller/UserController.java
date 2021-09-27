package com.offsidegaming.monitoring.controller;

import com.offsidegaming.monitoring.dto.UserDto;
import com.offsidegaming.monitoring.model.User;
import com.offsidegaming.monitoring.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("monitoring/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDto userDto){
        userRepository.save(User.toEntity(userDto));
        return "Success";
    }

    @GetMapping("/find/{id}")
    public UserDto findUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(User::toDto).orElse(null);
    }

    @GetMapping("/find-all")
    public List<UserDto> findAllUsers(){
        List<User> user = userRepository.findAll();
        return user.stream().map(User::toDto).collect(Collectors.toList());
    }


}
