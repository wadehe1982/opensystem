package com.xxx.opensys.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xxx.opensys.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> getByUserName(String userName);
	
}
