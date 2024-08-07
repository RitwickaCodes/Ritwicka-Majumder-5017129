package com.library.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve the BookService bean
        BookService bookService = context.getBean(BookService.class);
        
        // Test the BookService bean
        bookService.addBook("The Great Gatsby");
        bookService.addBook("Yellow Face");
        System.out.println("Books in the library: " + bookService.getAllBooks());
    }
}
