package com.example.bookstoreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Exercise 7
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
}
