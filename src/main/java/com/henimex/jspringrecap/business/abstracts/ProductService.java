package com.henimex.jspringrecap.business.abstracts;

import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.Result;
import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
    DataResult<Optional<Product>> getById(int product_id);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByProductNameEndsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
