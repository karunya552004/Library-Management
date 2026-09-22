package com.example.dto;

import com.example.enums.BookAvailability;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class BookRequestDTO {

    private int bookId;

    @NotBlank(message = "Book name cannot be empty")
    private String bookName;

    @NotBlank(message = "Author name cannot be empty")
    private String author;

    @Positive(message = "Price must be greater than 0")
    private double price;

    private BookAvailability availability;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public BookAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(BookAvailability availability) {
        this.availability = availability;
    }
}