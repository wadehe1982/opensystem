package com.xxx.opensys.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.entity.User;
import com.xxx.opensys.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public List<UserDTO> getByUserName(String userName){
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		List<User> list = userRepository.getByUserName(userName);
		
		if(CollectionUtils.isEmpty(list)){
			return dtoList;
		}
		for(User user: list){
			dtoList.add(user.toDto());
		}
		return dtoList;
	}
	
	@Transactional
	public UserDTO getById(Integer id){
		User user = userRepository.findOne(id);
		System.out.println(user);
		
//		User user1 = userRepository.findOne(id);
		
		if (user != null){
			return user.toDto();
		}
		return null;
	}
	
	@Transactional
	public UserDTO save(UserDTO dto){
		if(dto == null){
			return null;
		}
		User user = userRepository.save(new User(dto));
		if(user != null){
			return user.toDto();
		}
		return null;
	}
}
