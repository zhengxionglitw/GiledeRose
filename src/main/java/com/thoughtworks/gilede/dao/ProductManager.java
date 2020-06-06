package com.thoughtworks.gilede.dao;

import com.thoughtworks.gilede.model.Product;

import java.util.concurrent.ConcurrentHashMap;

public final class ProductManager {
    private static final ConcurrentHashMap<String, Product> PRODUCT_MAP =
            new ConcurrentHashMap<String, Product>(32);
    private ProductManager() {

    }
}
