package com.limbo.Demo.service;

import com.limbo.Demo.model.Product;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
@ToString
@Service
public class ProductService {

    List<Product> products = new ArrayList<>(List.of(
            new Product(3, "Phone", "Iphone 13", 3000.0),
            new Product(1, "Camera", "Cannon 200d", 1300.0),
            new Product(2, "TV", "Lg 4k", 6000)
    ));

    public Product getProductById(int productId) {
        return products.stream().
                filter(p -> p.getId() == productId).
                findFirst().
                orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + productId));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return;
            }
        }
        throw new NoSuchElementException("Product with ID " + product.getId() + " not found.");
    }

    public void deleteProduct(int productId) {
        boolean deleted = products.removeIf(p-> p.getId() == productId);
        if (!deleted)
            throw new NoSuchElementException("Product with ID " + productId + " not found.");
    }
}


