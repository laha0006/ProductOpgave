package com.example.productopgave.repository;

import com.example.productopgave.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> productList;
    private int nextId = 1;

    public ProductRepository() {
        productList = new ArrayList<>();
        Product milk = new Product();
        milk.setName("Milk");
        milk.setPrice(14);
        Product eggs = new Product();
        eggs.setName("Eggs");
        eggs.setPrice(37);
        addProduct(milk);
        addProduct(eggs);


    }

    public void addProduct(Product product) {
        product.setId(nextId++);
        productList.add(product);
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product getProductById(int id) {
        for(Product product : productList) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(Product updatedProduct) {
        for(Product product : productList) {
            if (product.getId() == updatedProduct.getId()) {
                int index = productList.indexOf(product);
                productList.set(index,updatedProduct);
                return;
            }
        }

    }

    public void deleteProductById(int id) {
        for(Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
                return;
            }
        }
    }
}
