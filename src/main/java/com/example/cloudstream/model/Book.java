package com.example.cloudstream.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String id;
    private String name;
    private String description;
    private String status = "unchecked";
    private float price;
}
