package com.henimex.jspringrecap.business.concretes;

import com.henimex.jspringrecap.business.abstracts.ProductService;
import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.Result;
import com.henimex.jspringrecap.core.utilities.results.SuccessDataResult;
import com.henimex.jspringrecap.core.utilities.results.SuccessResult;
import com.henimex.jspringrecap.dataAccess.abstracts.ProductDao;
import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(this.productDao.findAll(), "Data Load Successful");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult(product.getProductName() + " Product Added");
    }

    @Override
    public DataResult<Optional<Product>> getById(int product_id) {
        return new SuccessDataResult<>(this.productDao.findById(product_id),
                "Get by Id Operation Completed v2");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductName(productName), "Product Load By Name Successful");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId) , "Data Load Successful");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId), "Data Load Successful");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<>(this.productDao.getByCategoryIn(categories), "Data Load Successful");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameContains(productName), "Data Load Successful");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameStartsWith(productName), "Data Load Successful");
    }

    @Override
    public DataResult<List<Product>> getByProductNameEndsWith(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameEndsWith(productName), "Data Load Successful");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByNameAndCategory(productName, categoryId), "Data Load Successful");
    }
}
