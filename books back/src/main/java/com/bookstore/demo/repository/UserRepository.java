package com.bookstore.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}

