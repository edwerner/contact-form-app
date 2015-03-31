package com.contact.form.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.validation.Valid;
import com.contact.form.app.dao.CarDao;
import com.contact.form.app.domain.Car;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "cars")
public class CarController {

	@Autowired
	CarDao carDao;

	@RequestMapping(value = "/new/index", method = RequestMethod.GET)
	public Car car() {
		return new Car();
	}

	@RequestMapping(value = "/new/index", method = RequestMethod.POST)
	public ModelAndView newContact(@Valid @ModelAttribute("car") Car car,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return new ModelAndView("cars/new/index");
		}
		car.setModel(car.getModel());
		carDao.addCar(car);
		return new ModelAndView("cars/success/success");
	}

	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public ModelAndView listContacts(ModelMap model) {
		List<Car> carList = carDao.listCars();
		model.addAttribute("newCar", carList);
		return new ModelAndView("cars/list/all", model);
	}

	@RequestMapping(value = "/carsJson", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public byte[] getCars() throws IOException {
		final List<Car> carList = carDao.listCars();
		final OutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, carList);
		final byte[] cars = ((ByteArrayOutputStream) out).toByteArray();
		return cars;
	}

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public ModelAndView listIndividualCar(@PathVariable String id,
			ModelMap model) {
		Car car = carDao.listCarById(id);
		model.addAttribute("individualCar", car);
		return new ModelAndView("cars/list/index", model);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteIndividualCar(@PathVariable String id,
			ModelMap model) {
		Car deletedCar = carDao.listCarById(id);
		model.addAttribute("deletedCar", deletedCar);
		int carList = carDao.deleteCarById(id);
		model.addAttribute("individualCar", carList);
		return new ModelAndView("cars/delete/index", model);
	}
}