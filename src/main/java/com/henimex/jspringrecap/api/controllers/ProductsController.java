package com.henimex.jspringrecap.api.controllers;

import com.henimex.jspringrecap.business.abstracts.ProductService;
import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.ErrorDataResult;
import com.henimex.jspringrecap.core.utilities.results.Result;
import com.henimex.jspringrecap.core.utilities.results.SuccessDataResult;
import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get-by-id")
    public DataResult<Optional<Product>> getById(@RequestParam int product_id){
        var result = this.productService.getById(product_id);
        if (result.isSuccess()){
            return result;
        }
        return new ErrorDataResult<>("An Error Occured");
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

}
