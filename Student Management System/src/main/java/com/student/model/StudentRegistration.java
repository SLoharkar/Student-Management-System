package com.student.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "Table_Name")

public class StudentRegistration {

	@Id
	private int sno;
	
	private String name;
	private Date dob, doj;
		
	public int getSno() {
		return sno;
	}
	public void setStudNo(int studNo) {
		this.sno = studNo;
	}
	public String getName() {
		return name;
	}
	public void setStudName(String studName) {
		this.name = studName;
	}
	public Date getDob() {
		return dob;
	}
	public void setStudDOB(Date studDOB) {
		this.dob = studDOB;
	}
	public Date getDoj() {
		return doj;
	}
	public void setStudDOJ(Date studDOJ) {
		this.doj = studDOJ;
	}
	@Override
	public String toString() {
		return "StudentRegistration [sno=" + sno + ", name=" + name + ", dob=" + dob + ", doj=" + doj + "]";
	}
	


	
}

