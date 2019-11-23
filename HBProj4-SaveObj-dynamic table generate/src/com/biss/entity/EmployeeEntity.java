package com.biss.entity;

public class EmployeeEntity {
	private int empId;
	private String eName;
	private float sal;
	private String job;
	
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
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
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
