package com.example.demo1.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dao.CarRepository;
import com.example.demo1.model.Car;
import com.example.demo1.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private final CarService serv;
	
	public CarController(CarService service) {
		this.serv = service;
	}
	

	
	@PostMapping("/insertCar")
	public String saveCar(@RequestBody Car obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		String aa ="";
		try {
			 aa = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aa);
	
		return serv.addCar(obj);
		
	}
	@GetMapping("/getCars")
	public List<Car> getCar(){
	//	return (List<Car>) dao.findAll();
		return serv.getCar();
	}
	@GetMapping("/getByBrand/{brand}")
	public List<Car> getCar(@PathVariable("brand") String brand){
		return serv.getCar(brand);
	}


}
