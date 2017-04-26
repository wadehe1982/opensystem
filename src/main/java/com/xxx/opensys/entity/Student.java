package com.xxx.opensys.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.xxx.opensys.dto.StudentAddressDTO;
import com.xxx.opensys.dto.StudentDTO;

import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

	@Column(name = "studentId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;

	// @Basic(fetch=FetchType.LAZY)
	@Column(name = "name")
	private String name;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "studentAddressId")
	private List<StudentAddress> address = Lists.newArrayList();

	public StudentDTO toDTO() {
		StudentDTO dto = new StudentDTO();

		dto.setName(name);
		dto.setStudentId(studentId);
		
		dto.setAddress(Lists.transform(address, new Function<StudentAddress, StudentAddressDTO>() {

			@Override
			public StudentAddressDTO apply(StudentAddress input) {
				return input.toDTO();
			}
		}));
		return dto;
	}

}
