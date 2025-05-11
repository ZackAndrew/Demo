package com.limbo.Demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String category;
    private String name;
    private double price;
}
