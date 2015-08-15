package com.ontarget.api.jpa.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.AddressDAO;
import com.ontarget.api.repository.AddressRepository;
import com.ontarget.bean.AddressDTO;
import com.ontarget.entities.Address;

@Repository("addressJpaDAOImpl")
public class AddressJpaDAOImpl implements AddressDAO {
	@Resource
	private AddressRepository addressRepository;

	@Override
	public int addAddress(AddressDTO addressDTO) throws Exception {
		Address address = new Address();
		address.setAddress1(addressDTO.getAddress1());
		address.setAddress2(addressDTO.getAddress2());
		address.setCity(addressDTO.getCity());
		address.setState(addressDTO.getState());
		address.setZip(addressDTO.getZip());
		address.setCountry(addressDTO.getCountry());
		address.setAddressType(addressDTO.getAddressType());
		addressRepository.save(address);
		return address.getAddressId();
	}

	@Override
	public AddressDTO getAddress(int addressId) throws Exception {
		AddressDTO addressDTO = new AddressDTO();

		Address address = addressRepository.findByAddressId(addressId);

		addressDTO.setAddressId(addressId);
		addressDTO.setAddress1(address.getAddress1());
		addressDTO.setAddress2(address.getAddress2());
		addressDTO.setCity(address.getCity());
		addressDTO.setState(address.getState());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setZip(address.getZip());
		addressDTO.setAddressType(address.getAddressType());

		return addressDTO;

	}
	
	@Override
	public com.ontarget.response.bean.Address getAddressById(int addressId) throws Exception {
		com.ontarget.response.bean.Address addressDTO = new com.ontarget.response.bean.Address();

		Address address = addressRepository.findByAddressId(addressId);

		addressDTO.setAddressId(addressId);
		addressDTO.setAddress1(address.getAddress1());
		addressDTO.setAddress2(address.getAddress2());
		addressDTO.setCity(address.getCity());
		addressDTO.setState(address.getState());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setZip(address.getZip());
		addressDTO.setAddressType(address.getAddressType());
		return addressDTO;

	}

	@Override
	public boolean updateAddress(AddressDTO addressDTO) throws Exception {
		Address address = addressRepository.findByAddressId(addressDTO.getAddressId());
		address.setAddress1(addressDTO.getAddress1());
		address.setAddress2(addressDTO.getAddress2());
		address.setCity(addressDTO.getCity());
		address.setState(addressDTO.getState());
		address.setZip(addressDTO.getZip());
		address.setCountry(addressDTO.getCountry());
		address.setAddressType(addressDTO.getAddressType());
		addressRepository.save(address);
		return true;
	}

}
