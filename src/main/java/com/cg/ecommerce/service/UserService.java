package com.cg.ecommerce.service;

import java.util.List;

import com.cg.ecommerce.entity.Address;
import com.cg.ecommerce.entity.UserEntity;
import com.cg.ecommerce.exception.UserServiceException;
import com.cg.ecommerce.model.AddressDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	UserEntity createUser(UserEntity user) throws UserServiceException;
	UserEntity getUser(String email);
	UserEntity getUserByEmail(String email);
	UserEntity updateUser(String userId, UserEntity user);
	void deleteUser(String userId);
	List<UserEntity> getUsers();
	AddressDto saveAddress(Address address);
	List<AddressDto> getUserAllAddress(String email);
	AddressDto updateAddress(Address address);
	void  deleteAddress(Long addressId);
}
