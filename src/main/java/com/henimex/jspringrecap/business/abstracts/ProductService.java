package com.henimex.jspringrecap.business.abstracts;

import com.henimex.jspringrecap.entities.concretes.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(int product_id);


}
