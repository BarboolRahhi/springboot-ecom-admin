package com.cg.ecommerce.repository;

import com.cg.ecommerce.entity.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecRepository extends JpaRepository<ProductSpecification, String> {
}
