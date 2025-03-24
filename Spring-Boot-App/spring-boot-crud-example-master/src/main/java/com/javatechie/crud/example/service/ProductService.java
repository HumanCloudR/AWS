package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Save a single product
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    // Save multiple products
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    // Get all products
    public List<Product> getProducts() {
        return repository.findAll();
    }

    // Get product by ID
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Get product by name
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    // Delete product by ID
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product removed !! " + id;
    }

    // Update product details
    public Product updateProduct(Product product) {
        // First find the existing product in DB
        Product existingProduct = repository.findById(product.getId()).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            return repository.save(existingProduct);
        } else {
            // Product not found, return null or throw an exception based on your logic
            return null;
        }
    }

}
