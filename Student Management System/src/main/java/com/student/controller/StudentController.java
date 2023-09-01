package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.StudentRegistration;
import com.student.repository.StudentRepository;

@Controller
public class StudentController {
	
   	int stno;
   	
	@Autowired
	StudentRepository srepo;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();	
		
			mv.setViewName("Home");
		
		return mv;
	}
	
	@RequestMapping("/addStudent")
	public ModelAndView addstudent()
	{
		ModelAndView mv = new ModelAndView("addStudent");	
			
		return mv;
	}
	
	
	@RequestMapping("/addStud")
	public ModelAndView addStud(StudentRegistration sreg, int studNo)
	{
		ModelAndView mv = new ModelAndView("addStudent");	
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";


		//Find Data Using ID
		Optional<StudentRegistration> sreg1 = srepo.findById(studNo);
		
			
		if(sreg1.isPresent())
		{
			
			print=print + "<script>swal('User Already Exists');</script>";		

		}
		else
		{
			
			//Save Data in Student Registration Table
			
			srepo.save(sreg);
			
			print=print + "<script>swal('Registration Successful');</script>";				

		}
		
		mv.addObject("PrintSwal",print);
		
		return mv;
	}
	
	
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent()
	{
		ModelAndView mv = new ModelAndView("deleteStudent");	
		
		return mv;
	}
	
	@RequestMapping("/delStud")
	public ModelAndView delStud(int studNo)
	{
		ModelAndView mv = new ModelAndView("deleteStudent");	
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

		
			//Find User by ID
			Optional<StudentRegistration> sreg = srepo.findById(studNo);
		
 			
			if(sreg.isPresent())
			{
				//Record Delete By ID
				srepo.deleteById(studNo);
				
				print=print + "<script>swal('Record Deleted Successfully');</script>";
			}
			else
			{
				
				print=print + "<script>swal('Sorry Record Not Found');</script>";
			}
			
			mv.addObject("PrintSwal",print);
		
		return mv;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent()
	{
		ModelAndView mv = new ModelAndView("searchStudent");	
		
		return mv;
	}
	
	@RequestMapping("/searStud")
	public ModelAndView searStud(int studNo)
	{
		ModelAndView mv = new ModelAndView("searchStudent");
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

		//Find User By ID
		Optional<StudentRegistration> sreg = srepo.findById(studNo);
		
		
			
		if(sreg.isPresent())
		{	
			//Send Find Data to Another Reference
			StudentRegistration sreg1 = sreg.get();
			stno=sreg1.getSno();
			return updateView(sreg1);
		}
		else
		{
			print=print + "<script>swal('Sorry Record Not Found');</script>";
		}
		
		mv.addObject("PrintSwal",print);
		
		return mv;
	}
	
	
	
	
	@RequestMapping("/updateView")
	public ModelAndView updateView(StudentRegistration sreg)
	{
		ModelAndView mv = new ModelAndView("updateStudent");
	
		mv.addObject("Sno",sreg.getSno());
		mv.addObject("Sname",sreg.getName());
		mv.addObject("SDOB",sreg.getDob());
		mv.addObject("SDOJ",sreg.getDoj());
			
		return mv;
	}
	
	@RequestMapping("/updateStud")
	public ModelAndView update(StudentRegistration sreg)
	{
		ModelAndView mv = new ModelAndView("updateStudent");
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";
		
		StudentRegistration stupdate = new StudentRegistration();
		
		stupdate.setStudNo(stno);
		stupdate.setStudName(sreg.getName());
		stupdate.setStudDOB(sreg.getDob());
		stupdate.setStudDOJ(sreg.getDoj());

		srepo.save(stupdate);
		
		print=print + "<script>swal('Record Updated Successfully');</script>";

		mv.addObject("PrintSwal",print);
		
		mv.setViewName("searchStudent");
		
		return mv;
	}
	
	
	
	
	@RequestMapping("/viewAllStudent")
	public ModelAndView viewAllStudent(StudentRegistration sreg)
	{
		ModelAndView mv = new ModelAndView("viewAllStudent");
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

		List<StudentRegistration> s1 = srepo.findAll();
		
			if(s1.isEmpty())
			{			
				print=print + "<script>swal('Data Not Found');</script>";

				mv.addObject("PrintSwal",print);
				
				mv.setViewName("/Home");
			}
			else
			{
				String out="";
		
				for (StudentRegistration student : s1) 
				{
					out=out+"<tr>"
					+"<td>"+student.getSno()+"</td>"
					+"<td>"+student.getName()+"</td>"
					+"<td>"+student.getDob()+"</td>"
					+"<td>"+student.getDoj()+"</td>"
					+"</tr>";
					mv.addObject("Out",out);		    
				}
			}
		
		return mv;
	}



}		


