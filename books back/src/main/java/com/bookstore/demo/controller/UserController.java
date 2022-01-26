package com.bookstore.demo.controller;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.model.User;
import com.bookstore.demo.repository.UserRepository;
import com.bookstore.demo.service.BookService;
import com.bookstore.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/saveUser")
    public String saveUser( @RequestBody User user) {
        // save book to database
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {

        // call delete user method 
        this.userService.deleteUserbyId(id);
        return "redirect:/";
    }
}