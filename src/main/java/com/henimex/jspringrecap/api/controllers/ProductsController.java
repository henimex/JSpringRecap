package com.henimex.jspringrecap.api.controllers;

import com.henimex.jspringrecap.business.abstracts.ProductService;
import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.ErrorDataResult;
import com.henimex.jspringrecap.core.utilities.results.Result;
import com.henimex.jspringrecap.core.utilities.results.SuccessDataResult;
import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getAll")
    public DataResult<List<Product>> getAll() {
        var result = this.productService.getAll();
        //Ok
        if (result.isSuccess()) return result;
        //Bad Request
        return null;
    }

    @GetMapping("getBy-ProductId")
    public DataResult<Optional<Product>> getById(@RequestParam int product_id) {
        var result = this.productService.getById(product_id);
        if (result.isSuccess()) return result;
        return null;
    }

    @PostMapping("add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("getBy-ProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("getBy-ProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam String productName, int categoryId) {
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("getBy-ProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName, int categoryId) {
        return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("getBy-getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories) {
        return this.productService.getByCategoryIn(categories);
    }

    @GetMapping("getBy-getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("getBy-getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("getBy-getByProductNameEndsWith")
    public DataResult<List<Product>> getByProductNameEndsWith(@RequestParam String productName) {
        return this.productService.getByProductNameEndsWith(productName);
    }

    @GetMapping("getBy-getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName, int categoryId) {
        return this.productService.getByNameAndCategory(productName, categoryId);
    }


}
