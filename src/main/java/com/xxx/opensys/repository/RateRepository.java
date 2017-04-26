package com.xxx.opensys.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xxx.opensys.entity.Rate;


@Repository
public interface RateRepository extends CrudRepository<Rate, Long>{
	
	@Query(value="select r from Rate r where r.vendorId in (select o.vendorId from OrderData o where o.lastMonthOrders >= ?)")
	List<Rate> getByLastOrderData(int orderNumber);
	
	@Query(value="select r from Rate r, OrderData o where r.vendorId=o.vendorId and r.rateDate=o.orderDate and o.lastMonthOrders > 30")
	List<Rate> get(PageRequest request);

}
