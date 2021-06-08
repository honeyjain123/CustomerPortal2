package com.customeraddress.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customeraddress.info.model.Address;
import com.customeraddress.info.repository.AddressRepository;

@Service
public class CustomerService {

	@Autowired
	AddressRepository addressRepository;
	
	public String createAddress(Address address)
	{
		Address add = new Address();
		add.setAddresses(address.getAddresses());
		add.setEmail(address.getEmail());
		add.setPhone(address.getPhone());
		
		addressRepository.save(add);
		
		return "Customer created successfully";
	}
	
	public List<Address> getAddress()
	{
		List<Address> addresslist =  addressRepository.findAll();
		return addresslist;
	}
	
	public String updateAddress(long id,Address address)
	{
		Address tempaddress = addressRepository.findById(id).get();
		tempaddress.setAddresses(address.getAddresses());
		tempaddress.setEmail(address.getEmail());
		tempaddress.setPhone(address.getPhone());
		
		addressRepository.save(tempaddress);
		return "Customer details updated successfully";
	}
	
	public String deleteAddress(long id)
	{
		addressRepository.deleteById(id);
		return "Customer Deleted Successfully";
	}

	public Address getAddressById(long id) {
		
		Address address = addressRepository.findById(id).get();
		return address;
	}
}