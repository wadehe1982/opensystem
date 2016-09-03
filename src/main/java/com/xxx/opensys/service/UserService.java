package com.xxx.opensys.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.entity.User;
import com.xxx.opensys.repository.PageUserRepository;
import com.xxx.opensys.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PageUserRepository pageUserRepository;

	private static final Integer PAGE_SIZE = 3;

	@Transactional
	public List<UserDTO> getByUserName(String userName) {
		List<User> list = userRepository.getByUserNameAndActivated(userName, true);
		List<UserDTO> users = Lists.newArrayList();
		if (CollectionUtils.isEmpty(list)) {
			return users;
		}
		for (User user : list) {
			users.add(user.toDto());
		}
		return users;
	}

	@Transactional
	public UserDTO getOneByUserName(String userName) {
		List<User> list = userRepository.getByUserNameAndActivated(userName, true);

		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0).toDto();
	}

	@Transactional
	public UserDTO getById(Integer id) {
		User user = userRepository.findOne(id);
		System.out.println(user);

		// User user1 = userRepository.findOne(id);

		if (user != null) {
			return user.toDto();
		}
		return null;
	}

	@Transactional
	public UserDTO save(UserDTO dto) {
		if (dto == null) {
			return null;
		}
		User user = userRepository.save(new User(dto));
		if (user != null) {
			return user.toDto();
		}
		return null;
	}

	@Transactional
	public List<UserDTO> getAllUsers() {
		List<User> users = (List<User>) userRepository.findByActivated(true);
		List<UserDTO> userList = new ArrayList<UserDTO>();
		if (CollectionUtils.isEmpty(users)) {
			return userList;
		}
		for (User user : users) {
			userList.add(user.toDto());
		}
		return userList;
	}

	@Transactional
	public List<UserDTO> bulkInactive(List<Integer> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return null;
		}
		List<UserDTO> list = Lists.newArrayList();
		for (Integer id : ids) {
			User user = userRepository.findOne(id);
			if (user != null) {
				user.setActivated(false);
				User saved = userRepository.save(user);
				list.add(saved.toDto());
			}
		}
		return list;
	}

	@Transactional
	public Page<User> getAll(Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE);
		Page<User> page = pageUserRepository.findAll(pageRequest);
		return page;
	}
}
