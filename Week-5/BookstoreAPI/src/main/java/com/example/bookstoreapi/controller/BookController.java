package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.mapper.BookMapper;
import com.example.bookstoreapi.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Exercise 5:
    // GET method to retrieve all books with custom headers
    /*
     * @GetMapping
     * public ResponseEntity<List<Book>> getAllBooks() {
     * HttpHeaders headers = new HttpHeaders();
     * headers.add("X-Total-Count", String.valueOf(books.size()));
     * headers.add("X-Developer-Note", "This is a custom header example");
     * 
     * return new ResponseEntity<>(books, headers, HttpStatus.OK);
     * }
     * 
     * // GET method to retrieve a book by ID
     * // Exercise 3: Endpoint to fetch a book by its id
     * // Exercise 6: Implementing the exception
     * 
     * @GetMapping("/{id}")
     * public Book getBookById(@PathVariable Long id) {
     * return books.stream()
     * .filter(book -> book.getId().equals(id))
     * .findFirst()
     * .orElseThrow(() -> new BookNotFoundException("Book not found with id " +
     * id));
     * }
     */

    // Exercise 3: Endpoint to filter books based on query parameters like
    // title,author
    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        return books.stream()
                .filter(book -> (title == null || book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                        (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase())))
                .collect(Collectors.toList());
    }

    // Exercise 5
    // POST method to add a new book with custom response status
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // PUT method to update a book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        book.setIsbn(bookDetails.getIsbn());
        return book;
    }

    // DELETE method to remove a book by ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        books.remove(book);
        return "Book with id " + id + " has been deleted";
    }

    // Exercise 7 implementation
    public BookDTO getBookAsDTO(Book book) {
        return BookMapper.INSTANCE.toDTO(book);
    }

    public Book getBookFromDTO(BookDTO bookDTO) {
        return BookMapper.INSTANCE.toEntity(bookDTO);
    }

    // Exercise 9
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.getBookById(id);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            EntityModel<Book> resource = EntityModel.of(book);

            // Adding self-link to the resource
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                    .getBookById(id)).withSelfRel();
            resource.add(selfLink);

            // Adding link to all books
            Link allBooksLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                    .getAllBooks()).withRel("all-books");
            resource.add(allBooksLink);

            // Link to update book
            Link updateBookLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                    .updateBook(id, null)).withRel("update-book");
            resource.add(updateBookLink);

            // Link to delete book
            Link deleteBookLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                    .deleteBook(id)).withRel("delete-book");
            resource.add(deleteBookLink);

            return resource;
        } else {
            throw new BookNotFoundException("Book not found with id " + id);
        }
    }

    @GetMapping
    public List<EntityModel<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<EntityModel<Book>> resources = books.stream()
                .map(book -> {
                    EntityModel<Book> resource = EntityModel.of(book);

                    // Adding self-link to each book
                    Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                            .getBookById(book.getId())).withSelfRel();
                    resource.add(selfLink);

                    return resource;
                }).toList();

        return resources;
    }

    // Exercise 10
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Book getBookById1(@PathVariable Long id) {
        return bookService.getBookById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    // Exercise 11
    /*
     * @GetMapping
     * public List<Book> getAllBooks() {
     * return bookService.getBooks();
     * }
     */

}
