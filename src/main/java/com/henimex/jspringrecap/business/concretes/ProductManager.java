package com.henimex.jspringrecap.business.concretes;

import com.henimex.jspringrecap.business.abstracts.ProductService;
import com.henimex.jspringrecap.core.utilities.results.DataResult;
import com.henimex.jspringrecap.core.utilities.results.SuccessDataResult;
import com.henimex.jspringrecap.dataAccess.abstracts.ProductDao;
import com.henimex.jspringrecap.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Load Successful");
    }

//    @Override
//    public  DataResult<Product> getById(int product_id) {
//        //return new SuccessDataResult<Optional<Product>>(this.productDao.findById(product_id));
//    }
}
