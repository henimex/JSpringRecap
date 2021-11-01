package com.henimex.jspringrecap.dataAccess.abstracts;

import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

   Product getByProductName(String productName);

/*     Product getByProductNameAndCategoryId(String ProductName, int categoryId);

    List<Product> getByProductNameOrCategoryId(String ProductName, int categoryId);

    List<Product> getByCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    List<Product> getByProductNameEndsWith(String productName);

    //JPQL

    @Query("From Product where productName =:productName and category=:categoryId")
    List<Product> getByProductAndCategory(String productName, int categoryId);*/
}
