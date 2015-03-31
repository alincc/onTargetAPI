package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	Address findByAddressId(Integer addressId);
}
