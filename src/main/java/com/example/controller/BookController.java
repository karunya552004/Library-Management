package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.model.Book;
import com.example.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService service;


    // Constructor Injection

    public BookController(BookService service) {

        this.service = service;
    }


    // CREATE

    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {

        return service.addBook(book);
    }


    // READ ALL

    @GetMapping
    public List<Book> getAllBooks() {

        return service.getAllBooks();
    }


    // READ BY ID

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {

        return service.getBookById(id);
    }


    // UPDATE

    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable int id,
            @Valid @RequestBody Book book) {

        return service.updateBook(id, book);
    }


    // UPDATE AVAILABILITY

    @PatchMapping("/{id}")
    public Book updateAvailability(
            @PathVariable int id,
            @RequestParam boolean available) {

        return service.updateAvailability(id, available);
    }


    // DELETE

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {

        return service.deleteBook(id);
    }
}