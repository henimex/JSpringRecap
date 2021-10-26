package com.henimex.jspringrecap.business.abstracts;

import com.henimex.jspringrecap.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int product_id);
}
