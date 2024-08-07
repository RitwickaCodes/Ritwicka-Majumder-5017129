package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to add a book
    public void addBook() {
        bookRepository.saveBook(); 
        System.out.println("Book added");
    }
}
