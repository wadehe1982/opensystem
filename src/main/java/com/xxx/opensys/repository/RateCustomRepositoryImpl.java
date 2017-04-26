package com.xxx.opensys.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.xxx.opensys.entity.Rate;

@Repository
public class RateCustomRepositoryImpl implements RateCustomRepository {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Rate> get() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Rate rate = entityManager.find(Rate.class, 1);
		System.out.println(rate);
		TypedQuery<Rate> query = entityManager.createQuery
		("select r from Rate r, OrderData o where r.vendorId=o.vendorId and r.rateDate=o.orderDate and o.lastMonthOrders > 30", Rate.class);
		
		return Lists.newArrayList(query.getResultList());
	}

}
