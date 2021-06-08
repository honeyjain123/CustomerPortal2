package com.customeraddress.info.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.customeraddress.info.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
