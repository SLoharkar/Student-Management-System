package com.student.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.student.model.StudentRegistration;

public interface StudentRepository extends CrudRepository<StudentRegistration, Integer> {

	List<StudentRegistration> findAll();

}
