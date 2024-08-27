package com.example.bookstoreapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is mandatory")
    @Size(min = 1, max = 255)
    private String title;

    @NotNull(message = "Author is mandatory")
    @Size(min = 1, max = 255)
    private String author;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price should not be less than 0")
    private double price;

    @NotNull(message = "ISBN is mandatory")
    @Size(min = 10, max = 13)
    private String isbn;
    // Exercise 8: Optimistic Locking
    @Version
    private Long version;

    public Book(Long id, String title, String author, Double price, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

}