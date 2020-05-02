package com.cg.ecommerce.service;

import com.cg.ecommerce.entity.Category;
import com.cg.ecommerce.exception.ItemExistsException;

import java.util.List;

public interface CategoryManagementService {
    Category saveCategory(Category category) throws ItemExistsException;
    Category getCategoryById(int categoryId) throws ItemExistsException;
    Category updateCategory(Integer categoryId, Category category) throws ItemExistsException;
    void deleteCategory(Integer categoryId) throws ItemExistsException;
    List<Category> getCategories();
}
