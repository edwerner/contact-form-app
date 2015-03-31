package com.contact.form.app.dao;

import java.util.List;

import com.contact.form.app.domain.Car;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarDaoImpl implements CarDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCar(Car car) {
		this.sessionFactory.getCurrentSession().save(car);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Car> listCars() {
		return this.sessionFactory.getCurrentSession().createQuery("from Car").list();
	}

	@Override
	public Car listCarById(String id) {
		final Long longId = Long.valueOf(id);
		return (Car) this.sessionFactory.getCurrentSession().get(Car.class, longId); 
	}

	@Override
	public int deleteCarById(String id) {
		final Long longId = Long.valueOf(id);
		return this.sessionFactory.getCurrentSession().createQuery("delete Car where id = :id ").setLong("id", longId).executeUpdate();
	}
}