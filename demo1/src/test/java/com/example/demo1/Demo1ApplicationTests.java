package com.example.demo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo1.dao.CarRepository;
import com.example.demo1.model.Car;
import com.example.demo1.service.CarService;


@RunWith(SpringRunner.class)
@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	private CarService service;
	
	@MockBean
	private CarRepository repository;
	
	@Test
	public void getCarTest() {
		when(repository.findAll()).thenReturn(Stream.
				of(new Car(345,"PROTON","IRIZ",46000),new Car(347,"PERODUA","MYVI",55000)).collect(Collectors.toList()));
		assertEquals(2, service.getCar().size());
	}
	
	@Test
	public void saveCarTest() {
		Car car = new Car (999,"X70","PROTON",98000);
		when(repository.save(car)).thenReturn(car);
		assertEquals("Car Added",service.addCar(car));
	}
	
	@Test
	public void getCarbyBrandTest() {
		String brand = "PROT0N";
		when(repository.findByBrand(brand)).thenReturn(Stream.
				of(new Car(345,"PROTON","IRIZ",46000),new Car(347,"PROTON","X50",55000)).collect(Collectors.toList()));
		assertEquals(2, service.getCar(brand).size());
	}
	
	

}
