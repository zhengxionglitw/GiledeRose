package com.thoughtworks.gilede.service;

import com.thoughtworks.gilede.dao.constant.ErrorMessages;
import com.thoughtworks.gilede.model.Product;
import com.thoughtworks.gilede.model.ProductType;
import com.thoughtworks.gilede.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class ProductServiceTest {

    @Test(expected = RuntimeException.class)
    public void add_product_throw_exception_when_product_quality_gt_50() {
        ProductService productService = new ProductServiceImpl();
        try {
            Product product = new Product();
            product.setQuality(51);
            productService.addProduct(product);
        } catch (Exception e) {
            Assert.assertEquals(ErrorMessages.QUALITY_INVALID, e.getMessage());
            throw e;
        }
    }

    @Test(expected = RuntimeException.class)
    public void add_product_throw_exception_when_product_quality_lt_0() {
        ProductService productService = new ProductServiceImpl();
        try {
            Product product = new Product();
            product.setQuality(-1);
            productService.addProduct(product);
        } catch (Exception e) {
            Assert.assertEquals(ErrorMessages.QUALITY_INVALID, e.getMessage());
            throw e;
        }
    }

    @Test
    public void add_product_success() {
        ProductService productService = new ProductServiceImpl();
        Product product = new Product();
        product.setType(ProductType.NORMAL);
        product.setQuality(50);
        product.setSellIn(10);
        String productId = productService.addProduct(product);
        Assert.assertNotNull(productId);
        Assert.assertNotNull(productService.getById(productId));
    }
}
