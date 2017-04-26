package com.xxx.opensys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.opensys.dto.StudentDTO;
import com.xxx.opensys.entity.Student;
import com.xxx.opensys.repository.StudentRepository;

@Service
public class StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional(value="myJpaTM")
	public Student getStudent(){
		Student s = studentRepository.findOne(1l);
//		return s.toDTO();
		return s;
	}

}
