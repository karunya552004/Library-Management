package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookRequestDTO;
import com.example.dto.BookResponseDTO;
import com.example.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookService service;


    public BookController(BookService service) {

        this.service = service;
    }


    // CREATE

    @PostMapping
    public BookResponseDTO addBook(
            @Valid @RequestBody BookRequestDTO dto) {

        return service.addBook(dto);
    }


    // READ ALL

    @GetMapping
    public List<BookResponseDTO> getAllBooks() {

        return service.getAllBooks();
    }


    // READ BY ID

    @GetMapping("/{id}")
    public BookResponseDTO getBookById(
            @PathVariable int id) {

        return service.getBookById(id);
    }


    // UPDATE

    @PutMapping("/{id}")
    public BookResponseDTO updateBook(
            @PathVariable int id,
            @Valid @RequestBody BookRequestDTO dto) {

        return service.updateBook(id, dto);
    }


    // DELETE

    @DeleteMapping("/{id}")
    public String deleteBook(
            @PathVariable int id) {

        return service.deleteBook(id);
    }
}