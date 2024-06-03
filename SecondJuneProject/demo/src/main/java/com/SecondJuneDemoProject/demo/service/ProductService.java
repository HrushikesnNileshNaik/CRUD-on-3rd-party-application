package com.SecondJuneDemoProject.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SecondJuneDemoProject.demo.model.Product;

@Service

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    void updateProduct(Long id, Product product);
    public void deleteProduct(Long id);
    List<Product> getProductByCategory(String category);
}
