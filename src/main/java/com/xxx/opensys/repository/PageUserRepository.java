package com.xxx.opensys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xxx.opensys.entity.User;

@Repository
public interface PageUserRepository extends PagingAndSortingRepository<User, Long> {

	Page<User> findByUserName(String userName, Pageable pageRequest);

}
