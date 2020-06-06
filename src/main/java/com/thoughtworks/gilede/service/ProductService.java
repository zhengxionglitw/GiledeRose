package com.thoughtworks.gilede.service;

import com.thoughtworks.gilede.model.Product;

public interface ProductService {
    String addProduct(Product product);
    Product getById(String productId);
    Product reduceSellIn(String productId);
}
