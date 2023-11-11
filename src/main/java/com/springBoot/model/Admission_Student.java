package com.springBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Admission_Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer student_Id;
	private String student_name;
	private String student_emaId;
	private String student_class;
	private String student_FatherName;
	private String student_MontherName;
	private String student_Address;
	private String student_ZipCode;
	private String Mobile_Number;
	

}
