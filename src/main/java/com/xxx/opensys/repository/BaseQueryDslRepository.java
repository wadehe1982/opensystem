package com.xxx.opensys.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class BaseQueryDslRepository extends QueryDslRepositorySupport{

	public BaseQueryDslRepository(Class<BaseQueryDslRepository> domainClass) {
		super(domainClass);
	}

}
