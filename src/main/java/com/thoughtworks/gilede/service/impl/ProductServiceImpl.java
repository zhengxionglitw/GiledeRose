package com.thoughtworks.gilede.service.impl;

import com.thoughtworks.gilede.dao.ProductDao;
import com.thoughtworks.gilede.dao.constant.ErrorMessages;
import com.thoughtworks.gilede.dao.impl.ProductDaoImpl;
import com.thoughtworks.gilede.model.Product;
import com.thoughtworks.gilede.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private static final int MAX_QUALITY =  50;
    private static final int MIN_QUALITY = 0;
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public String addProduct(Product product) {
        if (product.getQuality() > MAX_QUALITY || product.getQuality() < MIN_QUALITY) {
            throw new RuntimeException(ErrorMessages.QUALITY_INVALID);
        }
        return productDao.addProduct(product);
    }

    @Override
    public Product getById(String productId) {
        return productDao.getById(productId);
    }
}
