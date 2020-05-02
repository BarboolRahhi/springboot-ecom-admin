package com.cg.ecommerce.repository;

import com.cg.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
    List<Product> findByInventoryRetailerId(int id);
    @Query("from Product p left join fetch p.inventory r where r.retailerId = :id")
    List<Product> getProductsOfRetailer(@Param("id") int id);
}
