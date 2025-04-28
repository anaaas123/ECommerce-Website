package com.example.anakompjuteri.service;

import com.example.anakompjuteri.dto.ProductDTO;
import com.example.anakompjuteri.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDTO productDto);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductsByCategory(String category);
    void deleteProduct(Long id);
    Product updateProduct(Long id, ProductDTO productDto);
}
