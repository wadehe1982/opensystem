package com.xxx.opensys.dto;

import java.util.Collection;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class StudentDTO {

	
    private long studentId;
	
	private String name;
	
	private Collection<StudentAddressDTO> address = Lists.newArrayList();
}
