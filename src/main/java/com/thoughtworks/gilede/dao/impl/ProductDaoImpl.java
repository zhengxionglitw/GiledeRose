package com.thoughtworks.gilede.dao.impl;

import com.thoughtworks.gilede.dao.ProductDao;
import com.thoughtworks.gilede.dao.ProductManager;
import com.thoughtworks.gilede.model.Product;

public class ProductDaoImpl implements ProductDao {

    @Override
    public String addProduct(Product product) {
        return ProductManager.addProduct(product);
    }

    @Override
    public Product getById(String productId) {
        return ProductManager.getById(productId);
    }
}
