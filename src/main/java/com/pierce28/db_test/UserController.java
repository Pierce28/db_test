package com.pierce28.db_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/get")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/getByEmail")
    @ResponseBody
    public Iterable<User> getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping(path = "/getById")
    @ResponseBody
    public User getUserById(@RequestParam Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public User addNewUser(@RequestBody NewUserRequest request) {
        User newUser = new User();

        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());

        userRepository.save(newUser);

        return newUser;
    }
}
