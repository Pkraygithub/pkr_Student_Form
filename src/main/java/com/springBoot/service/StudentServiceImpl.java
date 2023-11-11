package com.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.model.Admission_Student;
import com.springBoot.repositery.Student_Repositery;

@Service
public class StudentServiceImpl implements IStudent_Service {
	
	@Autowired
	private Student_Repositery repo;
	

	@Override
	public Integer saveStudent(Admission_Student std) {

		return repo.save(std).getStudent_Id();		
				
	}

	@Override
	public void updateStudentDetails(Admission_Student upstd) {
		
		repo.save(upstd);
	}

	@Override
	public void deleteStudentDetaisl(Integer id) {

		repo.deleteById(id);
	}

	@Override
	public Admission_Student getOneStudentId(Integer stid) {

		Optional<Admission_Student> st=repo.findById(stid);
		if(st.isPresent()) {
			
			return st.get();
		}
		return null;
	}

	@Override
	public List<Admission_Student> getAllStudentDetails() {

		List<Admission_Student> sst= repo.findAll();
		
		return sst;
	}

}
