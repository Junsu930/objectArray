package edu.kh.objarray.practice.model.vo;

public class Employee {
	
	private String name;
	private int salary;
	private String department;
	private int no;
	private String rank;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public Employee() {}
	
	public Employee( int no, String name, String department, String rank, int salary) {
		this.rank = rank;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.no = no;
	}
	
	public String info() {
		return "\n사번: "+ rank + " 이름 : " + name + " 부서 : " + department + " 직책 : "
				+ rank + " 급여 : " + salary ;
	}

	
}
