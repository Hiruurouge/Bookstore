package com.bookstore.demo.service;

import java.util.List;

import com.bookstore.demo.model.Book;

public interface BookService {
    List < Book > getAllBooks();
    void saveBook(Book book);
    Book getBookById(int id);
    void deleteBookById(int id);
}