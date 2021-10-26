package com.henimex.jspringrecap.dataAccess.abstracts;

import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
