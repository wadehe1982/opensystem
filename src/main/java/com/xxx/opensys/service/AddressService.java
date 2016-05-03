package com.xxx.opensys.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.opensys.dto.AddressDTO;
import com.xxx.opensys.entity.Address;
import com.xxx.opensys.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@PersistenceUnit
    private EntityManagerFactory factory;

	public AddressDTO getById(Integer id) {

		Address address = addressRepository.findOne(id);
		factory.getCache().evict(Address.class, 6);
		
		if (address != null) {
			return address.toDto();
		}
		return null;
	}
}
