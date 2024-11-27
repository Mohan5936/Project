package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private int id;

	private String name;

	private double salary;

	private String table;
	
	public String getTable() {
		return table;
	}


	public void setTable(String table) {
		this.table = table;
	}


	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
