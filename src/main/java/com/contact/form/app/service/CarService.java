package com.contact.form.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contact.form.app.dao.CarDao;
import com.contact.form.app.domain.Car;

@Service
public class CarService {
	
	@Autowired
	CarDao carDao;

	public List<Car> listCars() {
		return carDao.listCars();
	}

	public Car listCarById(String id) {
		return carDao.listCarById(id);
	}

	public int deleteCarById(String id) {
		return carDao.deleteCarById(id);
	}

	public void addCar(Car car) {
		carDao.addCar(car);
	}	
}