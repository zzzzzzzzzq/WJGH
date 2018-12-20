package cn.edu.wj.model;

import java.io.Serializable;

public class GPatientRegistration implements Serializable {
	
	 private Integer id;

	 private String patientIdentityid;

	 private String department;

	 private String doctor;

	 private Boolean isCompleted;

	 private Integer time;

	 private Integer payNo;
	 
	 private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientIdentityid() {
		return patientIdentityid;
	}

	public void setPatientIdentityid(String patientIdentityid) {
		this.patientIdentityid = patientIdentityid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getPayNo() {
		return payNo;
	}

	public void setPayNo(Integer pay_no) {
		this.payNo = pay_no;
	}

	
	
	 
	 
	
}
