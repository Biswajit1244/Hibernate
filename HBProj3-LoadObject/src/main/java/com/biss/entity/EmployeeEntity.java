package com.biss.entity;

public class EmployeeEntity {
	private int empId;
	private String eName;
	private double sal;
	private String job;
	
	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
		System.out.println("EmployeeEntity::0-Param");
	}
	//setters and getters method
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", eName=" + eName + ", sal=" + sal + ", job=" + job + "]";
	}
}
