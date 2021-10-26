package com.henimex.jspringrecap.api.controllers;

import com.henimex.jspringrecap.business.abstracts.ProductService;
import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all")
    public List<Product> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/get-by-id")
    public Product getById(@RequestParam("product_id") int product_id){
        return this.productService.getById(product_id);
    }
}
