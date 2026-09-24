package com.example.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BookResponseDTO> addBook(
            @Valid @RequestBody BookRequestDTO dto) {

        BookResponseDTO response = service.addBook(dto);

        URI location = URI.create("/books/" + response.getBookId());

        return ResponseEntity
                .created(location)
                .body(response);
    }


    // READ ALL - PAGINATION + SORTING

    @GetMapping
    public ResponseEntity<Page<BookResponseDTO>> getAllBooks(

            @PageableDefault(
                    size = 5,
                    sort = "bookId",
                    direction = Sort.Direction.ASC
            )
            Pageable pageable) {

        Page<BookResponseDTO> response =
                service.getAllBooks(pageable);

        return ResponseEntity
                .ok()
                .body(response);
    }


    // READ BY ID

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(
            @PathVariable int id) {

        BookResponseDTO response =
                service.getBookById(id);

        return ResponseEntity
                .ok()
                .body(response);
    }


    // UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(
            @PathVariable int id,
            @Valid @RequestBody BookRequestDTO dto) {

        BookResponseDTO response =
                service.updateBook(id, dto);

        return ResponseEntity
                .ok()
                .body(response);
    }


    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(
            @PathVariable int id) {

        String response = service.deleteBook(id);

        return ResponseEntity
                .ok()
                .body(response);
    }
}