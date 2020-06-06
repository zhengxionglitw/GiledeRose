package com.thoughtworks.gilede.service;

import com.thoughtworks.gilede.dao.constant.ErrorMessages;
import com.thoughtworks.gilede.model.Product;
import com.thoughtworks.gilede.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class ProductServiceTest {

    @Test(expected = RuntimeException.class)
    public void throw_exception_when_product_quality_gt_50() {
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
}
