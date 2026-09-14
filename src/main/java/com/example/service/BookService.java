package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    // CREATE
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // READ - Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // READ - Get book by ID
    public Book getBookById(int id) {

        for (Book book : books) {

            if (book.getBookId() == id) {
                return book;
            }
        }

        return null;
    }

    // UPDATE
    public Book updateBook(int id, Book newBook) {

        Book oldBook = getBookById(id);

        if (oldBook != null) {

            oldBook.setBookName(newBook.getBookName());
            oldBook.setAuthor(newBook.getAuthor());
            oldBook.setPrice(newBook.getPrice());
            oldBook.setAvailable(newBook.getAvailable());

            return oldBook;
        }

        return null;
    }

    // DELETE
    public boolean deleteBook(int id) {

        Book book = getBookById(id);

        if (book != null) {
            books.remove(book);
            return true;
        }

        return false;
    }
}