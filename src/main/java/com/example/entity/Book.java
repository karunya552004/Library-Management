package com.example.entity;

import com.example.enums.BookAvailability;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    private int bookId;

    private String bookName;

    private String author;

    private double price;

    @Enumerated(EnumType.STRING)
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