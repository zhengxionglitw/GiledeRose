package com.thoughtworks.gilede.dao;

import com.thoughtworks.gilede.model.Product;

public interface ProductDao {
    String addProduct(Product product);
    Product getById(String productId);
}
