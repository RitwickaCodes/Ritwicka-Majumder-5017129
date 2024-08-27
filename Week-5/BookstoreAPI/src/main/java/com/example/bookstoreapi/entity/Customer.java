package com.example.bookstoreapi.entity;

//Exercise 4
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Exercise 8
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is mandatory")
    @Size(min = 1, max = 255)
    private String name;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Phone number is mandatory")
    @Size(min = 10, max = 15)
    private String phoneNumber;

    // Exercise 8: Optimistic Locking
    @Version
    private Long version;
}
