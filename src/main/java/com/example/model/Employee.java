package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "employee")
public class Employee {
	
	
	@Id
	private int id;
	private String name;
	private String city;
	private String position;
	
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", position=" + position + "]";
	}
	
	

}
