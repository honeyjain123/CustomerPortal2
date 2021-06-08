package com.customeraddress.info;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customeraddress.info.model.Address;
import com.customeraddress.info.repository.AddressRepository;
import com.customeraddress.info.service.CustomerService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CustomerAddressPortalApplicationTests {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CustomerService custService;
	
	@Test
	@Order(1)
	public void testcreateAddress() {
		Address address = new Address();
		address.setId(1L);
		address.setAddresses("India");
		address.setEmail("mail.com");
		address.setPhone("45454");
		
		custService.createAddress(address);
		assertNotNull(addressRepository.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void testgetAddress()
	{
		List<Address> addresslist =  custService.getAddress();
		assertThat(addresslist).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testupdateAddress()
	{
		Address ad = addressRepository.findById(1L).get();
		ad.setAddresses("USA");	
		
		custService.updateAddress(1L, ad);

		assertNotEquals("India", addressRepository.findById(1L).get().getAddresses());
	}
	
	@Test
	@Order(4)
	public void testdeleteAddress()
	{
		custService.deleteAddress(1L);
		assertThat(addressRepository.existsById(1L)).isFalse();
	}
}