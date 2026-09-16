package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.BookAlreadyExistsException;
import com.example.exception.BookNotFoundException;
import com.example.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();


    // SAMPLE INPUTS

    public BookService() {

        Book book1 = new Book();
        book1.setBookId(1);
        book1.setBookName("Java Programming");
        book1.setAuthor("James Gosling");
        book1.setPrice(550);
        book1.setAvailable(true);


        Book book2 = new Book();
        book2.setBookId(2);
        book2.setBookName("Spring Boot");
        book2.setAuthor("Craig Walls");
        book2.setPrice(650);
        book2.setAvailable(true);


        Book book3 = new Book();
        book3.setBookId(3);
        book3.setBookName("Clean Code");
        book3.setAuthor("Robert Martin");
        book3.setPrice(750);
        book3.setAvailable(false);


        Book book4 = new Book();
        book4.setBookId(4);
        book4.setBookName("Python Programming");
        book4.setAuthor("Guido van Rossum");
        book4.setPrice(600);
        book4.setAvailable(true);


        Book book5 = new Book();
        book5.setBookId(5);
        book5.setBookName("Data Structures");
        book5.setAuthor("Mark Allen");
        book5.setPrice(700);
        book5.setAvailable(true);


        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }


    // CREATE

    public Book addBook(Book book) {

        // Check whether ID already exists

        for (Book existingBook : books) {

            if (existingBook.getBookId() == book.getBookId()) {

                throw new BookAlreadyExistsException(
                        "Book with ID " + book.getBookId()
                        + " already exists");
            }
        }

        books.add(book);

        return book;
    }


    // READ ALL

    public List<Book> getAllBooks() {

        if (books.isEmpty()) {

            throw new BookNotFoundException(
                    "No books available in the library");
        }

        return books;
    }


    // READ BY ID

    public Book getBookById(int id) {

        for (Book book : books) {

            if (book.getBookId() == id) {

                return book;
            }
        }

        throw new BookNotFoundException(
                "Book with ID " + id + " not found");
    }


    // UPDATE

    public Book updateBook(int id, Book newBook) {

        Book oldBook = getBookById(id);

        oldBook.setBookName(newBook.getBookName());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setPrice(newBook.getPrice());
        oldBook.setAvailable(newBook.isAvailable());

        return oldBook;
    }


    // UPDATE AVAILABILITY

    public Book updateAvailability(int id, boolean available) {

        Book book = getBookById(id);

        book.setAvailable(available);

        return book;
    }


    // DELETE

    public String deleteBook(int id) {

        Book book = getBookById(id);

        books.remove(book);

        return "Book deleted successfully";
    }
}