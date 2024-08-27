package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Exercise 7
@Data
@AllArgsConstructor
@NoArgsConstructor
// Custom Deserialization
@JsonDeserialize(using = CustomPriceDeserializer.class)
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    // Custom Serialization
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "##.##")
    private double price;

}

class CustomPriceDeserializer extends JsonDeserializer<Double> {
    @Override
    public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String priceAsString = p.getText();
        return Double.valueOf(priceAsString.replace(",", "."));
    }
}