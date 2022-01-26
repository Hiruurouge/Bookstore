package com.bookstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.demo.model.Book;


@Repository
public interface BooksRepository extends JpaRepository<Book,Integer> {

}

