package com.contact.form.app.dao;

import java.util.List;

import com.contact.form.app.domain.Car;

public interface CarDao {
    void addCar(Car car);
    List<Car> listCars();
    Car listCarById(String id);
	int deleteCarById(String id);
}