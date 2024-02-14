package com.example.productopgave.service;

import com.example.productopgave.model.Product;
import com.example.productopgave.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.addProduct(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteProductById(int id) {
        productRepository.deleteProductById(id);
    }
}
