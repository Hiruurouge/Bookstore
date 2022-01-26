package com.bookstore.demo.service;

import java.util.List;

import com.bookstore.demo.model.User;

public interface UserService {
    List < User > getAllUser();
    void saveUser(User user);
    void deleteUserbyId(int id);
}