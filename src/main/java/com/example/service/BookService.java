package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.BookRequestDTO;
import com.example.dto.BookResponseDTO;
import com.example.entity.Book;
import com.example.exception.BookAlreadyExistsException;
import com.example.exception.BookNotFoundException;
import com.example.exception.ExceptionConstant;
import com.example.mapper.BookMapper;
import com.example.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;

    private final BookMapper mapper;


    public BookService(
            BookRepository repository,
            BookMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }


    // CREATE

    public BookResponseDTO addBook(BookRequestDTO dto) {

        if (repository.existsById(dto.getBookId())) {

            throw new BookAlreadyExistsException(
                    String.format(
                            ExceptionConstant.BOOK_ALREADY_EXISTS,
                            dto.getBookId()));
        }


        Book book = mapper.toBook(dto);

        Book savedBook = repository.save(book);

        return mapper.toResponseDTO(savedBook);
    }


    // READ ALL

    public List<BookResponseDTO> getAllBooks() {

        List<Book> books = repository.findAll();


        if (books.isEmpty()) {

            throw new BookNotFoundException(
                    ExceptionConstant.NO_BOOKS_AVAILABLE);
        }


        return books.stream()
                .map(mapper::toResponseDTO)
                .toList();
    }


    // READ BY ID

    public BookResponseDTO getBookById(int id) {

        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                String.format(
                                        ExceptionConstant.BOOK_NOT_FOUND,
                                        id)));


        return mapper.toResponseDTO(book);
    }


    // UPDATE

    public BookResponseDTO updateBook(
            int id,
            BookRequestDTO dto) {


        Book oldBook = repository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(
                                String.format(
                                        ExceptionConstant.BOOK_NOT_FOUND,
                                        id)));


        oldBook.setBookName(dto.getBookName());

        oldBook.setAuthor(dto.getAuthor());

        oldBook.setPrice(dto.getPrice());

        oldBook.setAvailability(dto.getAvailability());


        Book updatedBook = repository.save(oldBook);


        return mapper.toResponseDTO(updatedBook);
    }


    // DELETE

    public String deleteBook(int id) {


        if (!repository.existsById(id)) {

            throw new BookNotFoundException(
                    String.format(
                            ExceptionConstant.BOOK_NOT_FOUND,
                            id));
        }


        repository.deleteById(id);


        return ExceptionConstant.BOOK_DELETED;
    }
}