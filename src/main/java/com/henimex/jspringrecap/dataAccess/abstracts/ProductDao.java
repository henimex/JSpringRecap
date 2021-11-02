package com.henimex.jspringrecap.dataAccess.abstracts;

import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String ProductName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String ProductName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    List<Product> getByProductNameEndsWith(String productName);

    //JPQL
    @Query("From Product where productName =:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);
}
