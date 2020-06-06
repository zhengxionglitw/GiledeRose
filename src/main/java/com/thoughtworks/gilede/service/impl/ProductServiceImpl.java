package com.thoughtworks.gilede.service.impl;

import com.thoughtworks.gilede.dao.constant.ErrorMessages;
import com.thoughtworks.gilede.model.Product;
import com.thoughtworks.gilede.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private static final int MAX_QUALITY =  50;
    private static final int MIN_QUALITY = 0;

    @Override
    public void addProduct(Product product) {
        if (product.getQuality() > MAX_QUALITY || product.getQuality() < MIN_QUALITY) {
            throw new RuntimeException(ErrorMessages.QUALITY_INVALID);
        }
    }
}
