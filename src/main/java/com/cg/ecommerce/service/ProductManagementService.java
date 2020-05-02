package com.cg.ecommerce.service;

import com.cg.ecommerce.entity.Category;
import com.cg.ecommerce.entity.Product;
import com.cg.ecommerce.exception.ItemExistsException;

import java.util.List;

public interface ProductManagementService {

    Product saveProduct(Product product) throws ItemExistsException;
    Product getProductById(int productId) throws ItemExistsException;
    Product updateProduct(Integer productId, Product product) throws ItemExistsException;
    void deleteProduct(Integer productId) throws ItemExistsException;
    List<Product> getProducts();
    List<Product> getRetailerProducts(int id);
}
