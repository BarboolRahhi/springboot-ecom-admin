package com.cg.ecommerce.service;

import com.cg.ecommerce.entity.ProductSpecification;

import java.util.List;

public interface ProductSpecManagementService {
    List<ProductSpecification> addProductSpec(List<ProductSpecification> specification);
}
