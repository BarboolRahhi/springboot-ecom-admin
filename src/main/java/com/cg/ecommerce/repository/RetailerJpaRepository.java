package com.cg.ecommerce.repository;

import com.cg.ecommerce.entity.RetailerInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetailerJpaRepository extends JpaRepository<RetailerInventory, Integer> {
    List<RetailerInventory> findByRetailerNameContainingIgnoreCase(String name);
}
