package com.xxx.opensys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xxx.opensys.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
