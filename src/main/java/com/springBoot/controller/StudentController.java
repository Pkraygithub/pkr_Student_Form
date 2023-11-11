package com.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.model.Admission_Student;
import com.springBoot.service.IStudent_Service;



@Controller
@RequestMapping("/admission")
public class StudentController {

	@Autowired
	private IStudent_Service service;
	
	@GetMapping("/home")
	public String saveHome(Model model) {
		
		model.addAttribute("studetForm", new Admission_Student());
		
		return "index";
		
	}
	
	
	@PostMapping("/saveForm")
	public String saveAdmissionDetails(@ModelAttribute Admission_Student admission_Student,Model model ) {
		
		Integer student=service.saveStudent(admission_Student);
		
		String msg="Admission is Successfully and Roll no is ->"+student;
		
		model.addAttribute("studentRegistered", msg);
		
		//return "index";
		
		return "redirect:home";		
	}
	
	
	@GetMapping("/showall")
	public String showallRecords(Model model) {
		
		List<Admission_Student> ad= service.getAllStudentDetails();
		
		model.addAttribute("showAll", ad);
		return "showAllRecords";
		
	}
	
	@GetMapping("/delete")
	public String deleteAdmissionRecords(@RequestParam Integer sid) {
		
	 service.deleteStudentDetaisl(sid);
		return "redirect:showall";
	}
	
	@GetMapping("/edit")
	public String editAdmissionRecord(@RequestParam Integer sid,Model model) {
		
		
	Admission_Student uas=	service.getOneStudentId(sid);
	model.addAttribute("updateAS", uas);
	return "editPage";
	
	}
	
	
	@PostMapping("/update")
	public String upateAdmissionForm(@ModelAttribute Admission_Student uas) {
		
		service.updateStudentDetails(uas);
		return "redirect:showall";
		
	}
	
}
