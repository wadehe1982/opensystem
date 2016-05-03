package com.xxx.opensys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xxx.opensys.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
