package com.cg.ecommerce.service;

import com.cg.ecommerce.entity.Category;
import com.cg.ecommerce.exception.ItemExistsException;
import com.cg.ecommerce.repository.CategoryJpaRepository;
import com.cg.ecommerce.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManagementServiceImpl implements CategoryManagementService {

    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    public Category saveCategory(Category category) throws ItemExistsException {
        if (categoryJpaRepository.findFirstByCategoryNameIgnoreCase(category.getCategoryName()) != null)
            throw new ItemExistsException(AppConstants.ID_ALREADY_EXISTS);
        return categoryJpaRepository.save(category);
    }

    public void deleteCategory(Integer categoryId) throws ItemExistsException {
        if (!categoryJpaRepository.findById(categoryId).isPresent())
            throw new ItemExistsException(AppConstants.ID_NOT_EXISTS);
        categoryJpaRepository.deleteById(categoryId);
    }

    public Category updateCategory(Integer categoryId, Category category) throws ItemExistsException {
        Category returnCategory = getCategoryById(categoryId);
        if (!returnCategory.getCategoryName().equalsIgnoreCase(category.getCategoryName()))
            if (categoryJpaRepository.findFirstByCategoryNameIgnoreCase(category.getCategoryName()) != null)
                throw new ItemExistsException(AppConstants.ID_ALREADY_EXISTS);
        returnCategory.setCategoryName(category.getCategoryName());
        return categoryJpaRepository.save(returnCategory);
    }

    public Category getCategoryById(int categoryId) throws ItemExistsException {
        return categoryJpaRepository.findById(categoryId)
                .orElseThrow(() -> new ItemExistsException(AppConstants.ID_NOT_EXISTS));
    }

    public List<Category> getCategories() {
        return categoryJpaRepository.findAll();
    }

}
