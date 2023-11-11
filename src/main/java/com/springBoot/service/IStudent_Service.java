package com.springBoot.service;

import java.util.List;

import com.springBoot.model.Admission_Student;

public interface IStudent_Service {

	Integer saveStudent(Admission_Student std);
	
	void updateStudentDetails(Admission_Student upstd);
	void deleteStudentDetaisl(Integer id);
	
	Admission_Student getOneStudentId(Integer stid);
	
	List<Admission_Student> getAllStudentDetails();
	
	

}
