package com.cg.ecommerce.service;

import com.cg.ecommerce.entity.ProductSpecification;
import com.cg.ecommerce.repository.ProductSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductSpecManagementServiceImpl implements ProductSpecManagementService {

    @Autowired
    ProductSpecRepository productSpecRepository;

    @Override
    public List<ProductSpecification> addProductSpec(List<ProductSpecification> specification) {
        return productSpecRepository.saveAll(specification);
    }
}
