package com.xxx.opensys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xxx.opensys.dto.StudentAddressDTO;

import lombok.Data;

@Entity
@Table(name = "studentaddress")
@Data
public class StudentAddress {
	
	@Column(name="studentAddressId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long studentAddressId;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="zipcode")
	private String zipcode;
	
	public StudentAddressDTO toDTO(){
		StudentAddressDTO dto = new StudentAddressDTO();
		dto.setAddress1(address1);
		dto.setAddress2(address2);
		dto.setStudentAddressId(studentAddressId);
		dto.setZipcode(zipcode);
		return dto;
	}

}
