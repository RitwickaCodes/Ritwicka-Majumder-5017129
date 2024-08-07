package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<String> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public void addBook(String book) {
        bookRepository.saveBook(book);
    }
}
