package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<String> books = new ArrayList<>();

    public List<String> findAllBooks() {
        return books;
    }

    public void saveBook(String book) {
        books.add(book);
    }
}
