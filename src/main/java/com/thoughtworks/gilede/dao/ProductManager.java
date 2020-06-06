package com.thoughtworks.gilede.dao;

import com.thoughtworks.gilede.model.Product;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class ProductManager {
    private static final ConcurrentHashMap<String, Product> PRODUCT_MAP =
            new ConcurrentHashMap<String, Product>(32);
    private ProductManager() {

    }

    public static String addProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        PRODUCT_MAP.put(product.getId(), product);
        return product.getId();
    }

    public static Product getById(String id) {
        return PRODUCT_MAP.get(id);
    }
}
