package com.example.exception;

public class ExceptionConstant {

    public static final String BOOK_NOT_FOUND =
            "Book with ID %d not found";

    public static final String BOOK_ALREADY_EXISTS =
            "Book with ID %d already exists";

    public static final String NO_BOOKS_AVAILABLE =
            "No books available in the library";

    public static final String BOOK_DELETED =
            "Book deleted successfully";

    private ExceptionConstant() {
        // Prevent object creation
    }
}