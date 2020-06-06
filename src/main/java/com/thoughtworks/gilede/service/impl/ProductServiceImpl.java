package com.thoughtworks.gilede.service.impl;

import com.thoughtworks.gilede.dao.ProductDao;
import com.thoughtworks.gilede.dao.constant.ErrorMessages;
import com.thoughtworks.gilede.dao.impl.ProductDaoImpl;
import com.thoughtworks.gilede.model.Product;
import com.thoughtworks.gilede.model.ProductType;
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

    @Override
    public Product reduceSellIn(String productId) {
        Product product = productDao.getById(productId);
        if (product.getType() == ProductType.NORMAL) {
            product.setSellIn(product.getSellIn() - 1);
            product.setQuality(product.getQuality() - (product.getSellIn() < 0 ? 2 : 1));
            product.setQuality(product.getQuality() < 0 ? 0 : product.getQuality());
        } else if (product.getType() == ProductType.BACKSTAGE_PASS) {
            product.setSellIn(product.getSellIn() - 1);
            if (product.getSellIn() <= 10) {

            }
        }
        return product;
    }
}
