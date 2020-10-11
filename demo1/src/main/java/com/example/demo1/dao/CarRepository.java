package com.example.demo1.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo1.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer>{
	
	 List<Car> findByBrand(String brand);
}
