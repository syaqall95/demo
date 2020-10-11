package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.dao.CarRepository;
import com.example.demo1.model.Car;

@Service
public class CarService {
	
	
	@Autowired
	private CarRepository dao;
	
	public CarService(CarRepository dao) {
		this.dao = dao;
	}
	
	public String addCar(Car obj) {
		
		
		if(obj.getName().length() > 50 || obj.getName().length() <= 0)
			return "Name cannot be null or exceed 50 in length";
		else if(obj.getBrand().length() > 50 || obj.getBrand().length() <= 0 )
			return "Brand cannot be null or exceed 50 in length";
		else if(obj.getPrice() <= 0 )
			return "Price cannot exceed be 0 or less";
		else {
			dao.save(obj);
			return "Car Added";
		}

	}

	public List<Car> getCar(){
		
		List<Car> cars = (List<Car>) dao.findAll();
		System.out.println("Getting Data : " + cars);
		return cars;
	}
	
	public List<Car> getCar(String brand){
		System.out.println("BRAND : " + brand);
		List<Car> cars = (List<Car>)  dao.findByBrand(brand);
		return cars;
	}
	
	
}
