package com.henimex.jspringrecap.api.controllers;

import com.henimex.jspringrecap.business.abstracts.ProductService;
import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.Result;
import com.henimex.jspringrecap.entities.concretes.Product;
import com.henimex.jspringrecap.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("getAllSorted")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

    @GetMapping("getBy-productId")
    public DataResult<Optional<Product>> getById(@RequestParam int product_id) {
        var result = this.productService.getById(product_id);
        if (result.isSuccess()) return result;
        return null;
    }

    @PostMapping("add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("getBy-productName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("getBy-productNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("getBy-productNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("getBy-categoryIdesIn")
    public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories) {
        return this.productService.getByCategoryIn(categories);
    }

    @GetMapping("getBy-productNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("getBy-productNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("getBy-productNameEndsWith")
    public DataResult<List<Product>> getByProductNameEndsWith(@RequestParam String productName) {
        return this.productService.getByProductNameEndsWith(productName);
    }

    @GetMapping("getBy-nameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName, int categoryId) {
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("getBy-ProductDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductDetails(){
        return this.productService.getProductDetails();
    }


}
