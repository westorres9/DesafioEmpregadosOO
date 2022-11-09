package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private Address address;
	private String name;
	private Integer payDay;
	
	private List<Employee> employees = new ArrayList<>();
	
	public Department() {
	}

	public Department(String name, Integer payDay, Address address) {
		this.address = address;
		this.name = name;
		this.payDay = payDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPayDay() {
		return payDay;
	}

	public void setPayDay(Integer payDay) {
		this.payDay = payDay;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}
	
	public void removeEmployee(Employee emp) {
		employees.remove(emp);
	}
	
	public double payRoll() {
		double sum = 0.0;
		
		for(Employee emp : employees) {
			sum += emp.getSalary();
		}
		return sum;
	}

	@Override
	public String toString() {
		
		return String.format("%.2f", payRoll());
	}
	
	
	
}
