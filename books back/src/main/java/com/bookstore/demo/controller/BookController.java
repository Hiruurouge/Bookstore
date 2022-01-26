package com.bookstore.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.service.BookService;
@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List<Book> fetchBooks(){
        return bookService.getAllBooks();
    }
    // display list of books
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBook", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        // create model attribute to bind form data
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook( @RequestBody Book book) {
        // save book to database
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get book from the service
        Book book = bookService.getBookById(id);

        // set book as a model attribute to pre-populate the form
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {

        // call delete book method 
        this.bookService.deleteBookById(id);
        return "redirect:/";
    }
   
}