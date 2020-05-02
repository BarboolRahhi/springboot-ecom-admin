package com.cg.ecommerce.service;

import com.cg.ecommerce.entity.Product;
import com.cg.ecommerce.entity.RetailerInventory;
import com.cg.ecommerce.exception.ItemExistsException;
import com.cg.ecommerce.repository.RetailerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RetailerManagementService {
    RetailerInventory saveRetailer(RetailerInventory retailerInventory) throws ItemExistsException;
    RetailerInventory updateRetailer(Integer retailerId, RetailerInventory retailerInventory) throws ItemExistsException;
    void deleteRetailer(Integer retailerId) throws ItemExistsException;
    RetailerInventory getRetailerById(Integer retailerId) throws ItemExistsException;
    List<RetailerInventory> getRetailers();
    List<RetailerInventory> getRetailersByName(String name) throws ItemExistsException;


}
