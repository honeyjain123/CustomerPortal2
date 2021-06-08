package com.customeraddress.info.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customeraddress.info.exception.CustomerNotFoundException;
import com.customeraddress.info.model.Address;
import com.customeraddress.info.service.CustomerService;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/addressservice")
public class AddressController {
	
	Logger logger = LoggerFactory.getLogger(AddressController.class); 
	
	@Autowired
    private CustomerService customerService;
    @PostMapping("/customeraddress/")
    @ApiOperation(value = "Creates a new Customer", notes = "It creates a new Customer with its address details and save it in H2 database")
    public String createAddress(@RequestBody Address address)
    {
    	logger.error("Inside Post method..");
    	return customerService.createAddress(address);
    }

    @GetMapping("/customeraddress/")
    @ApiOperation(value = "Display All Customers", notes = "It fetches all the Customers Address details from H2 database")
    public List<Address> getAddress()
    {
    	logger.error("Inside Get method..");
    	return customerService.getAddress();
    }
    
    @GetMapping("/customeraddress/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long id) throws CustomerNotFoundException
    {
    	logger.error("Inside GetById method..");
    	return new ResponseEntity<>(customerService.getAddressById(id), HttpStatus.OK);
    }
    
    @PutMapping("/customeraddress/{id}")
    @ApiOperation(value = "Updates the details of a Customer By its Id", notes = "It updates the address details of a particular Customer from H2 database by its Id")
    public ResponseEntity<Object> updateAddress(@PathVariable long id,@RequestBody Address address) throws CustomerNotFoundException
    {
    	logger.error("Inside Put method..");
    	return new ResponseEntity<>(customerService.updateAddress(id, address), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/customeraddress/{id}")
    @ApiOperation(value = "Deletes a particular Customer", notes = "It deletes a particular customer by its Id")
    public ResponseEntity<Object> deleteAddress(@PathVariable long id) throws CustomerNotFoundException
    {
    	logger.error("Inside DeletebyId method..");
    	return new ResponseEntity<>(customerService.deleteAddress(id),HttpStatus.OK);
    }
}