package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    
    @PostMapping
    public Book addBook( @RequestBody Book book) {
        return service.addBook(book);
    }

  
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable int id,
            @Valid @RequestBody Book book) {

        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {

        boolean result = service.deleteBook(id);

        if (result) {
            return "Book deleted successfully";
        }

        return "Book not found";
    }
}