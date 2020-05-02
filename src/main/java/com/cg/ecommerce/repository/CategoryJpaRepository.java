package com.cg.ecommerce.repository;

import com.cg.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Integer> {
   Category findFirstByCategoryNameIgnoreCase(String categoryName);
}
