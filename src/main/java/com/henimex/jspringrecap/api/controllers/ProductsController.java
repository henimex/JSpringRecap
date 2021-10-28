package com.henimex.jspringrecap.api.controllers;

import com.henimex.jspringrecap.business.abstracts.ProductService;
import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.ErrorDataResult;
import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all")
    public DataResult<List<Product>> getAll() {
        var result = this.productService.getAll();
        if (result.isSuccess()) {
            return result;
        }
        return new ErrorDataResult<>("An Error Occurred");
    }

//    @GetMapping("/get-by-id")
//    public Optional<Product> getById(@RequestParam("product_id") int product_id){
//        return this.productService.getById(product_id);
//    }
}
