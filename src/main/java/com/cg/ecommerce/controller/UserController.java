package com.cg.ecommerce.controller;

import com.cg.ecommerce.entity.Address;
import com.cg.ecommerce.entity.UserEntity;
import com.cg.ecommerce.exception.UserServiceException;
import com.cg.ecommerce.model.AddressDto;
import com.cg.ecommerce.model.MessageResponse;
import com.cg.ecommerce.model.UserResponse;
import com.cg.ecommerce.model.UserSignUpRequetModel;
import com.cg.ecommerce.service.UserService;
import com.cg.ecommerce.utils.AppConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping(path = "/{email}")
	public UserEntity getUser(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	@PostMapping(path = "/signup")
	public UserResponse createUser(@RequestBody UserSignUpRequetModel userDetails) throws UserServiceException {
		UserResponse returnValue = new UserResponse();

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDetails, userEntity);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		userEntity.setRole("ROLE_USER");
		UserEntity returnEntity =  userService.createUser(userEntity);
		BeanUtils.copyProperties(returnEntity, returnValue);
		return returnValue;
	}

	@PostMapping("address")
	public AddressDto addAddress(@RequestBody Address address) {
		return userService.saveAddress(address);
	}

	@GetMapping("address/{email}")
	public List<AddressDto> getUserAddresses(@PathVariable("email") String email) {
		return userService.getUserAllAddress(email);
	}

	@CrossOrigin
	@DeleteMapping("address/{id}")
	public MessageResponse deleteAddress(@PathVariable("id") Long addressId) {
		userService.deleteAddress(addressId);
		return  new MessageResponse(AppConstants.DELETE_ADDRESS);
	}
}
