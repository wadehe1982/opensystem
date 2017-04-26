package com.xxx.opensys.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "rate")
@Data
public class Rate {

	
	@Column(name="rateId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rateId;
	
	@Column(name="rate")
	private double rate;
	
	@Column(name="vendorId")
	private String vendorId;
	
	@Column(name="rateDate")
	private Date rateDate;
}
