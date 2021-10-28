package com.henimex.jspringrecap.business.abstracts;

import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.entities.concretes.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    DataResult<List<Product>> getAll();

    //DataResult<Product> getById(int product_id);


}
