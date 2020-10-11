package com.example.demo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="CAR")
public class Car {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String brand;
	private Integer price;
	
	
	
	
	public Car() {
	}

	public Car(Integer id, String name, String brand, Integer price) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}