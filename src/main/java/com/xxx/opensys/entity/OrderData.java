package com.xxx.opensys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_data")
public class OrderData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderDataId")
	private long orderDataId;
	
	@Column(name="vendorId")
	private String vendorId;
	
	@Column(name="lastMonthOrders")
	private int lastMonthOrders;
	
	@Column(name="orderDate")
	private Date orderDate;

}
