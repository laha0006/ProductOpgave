package com.example.productopgave.controller;

import com.example.productopgave.model.Product;
import com.example.productopgave.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getProducts(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product",new Product());
        return "addProduct";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/update")
    public String updateById(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        return "updateProduct";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }

}
