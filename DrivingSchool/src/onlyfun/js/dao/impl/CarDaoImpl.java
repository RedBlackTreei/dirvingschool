package onlyfun.js.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onlyfun.js.dao.CarDao;
import onlyfun.js.model.Car;

@Repository
public class CarDaoImpl implements CarDao {
	
	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public List<Car> getCarByCoach(long coachId) {
		return null;
	}

	@Transactional
	public Car getCarById(long carId) {
		Car car = (Car)this.hibernateTemplate.get(Car.class, carId);
		return car;
	}

	@Transactional
	public List<Car> getCarByType(String type) {
		@SuppressWarnings("unchecked")
		List<Car> cars = this.hibernateTemplate.find("from Car c where c.type = '"+type+"'");
		return cars;
	}

	@Transactional
	public Car getCarByPlateNum(String plateNum) {
		Car car = (Car)this.hibernateTemplate.find("from Car c where c.plateNum = '"+plateNum+"'").get(0);
		return car;
	}

	@Transactional
	public List<Car> getByStudent(long stuId) {
		return null;
	}

	@Transactional
	public void update(Car car) {
		this.hibernateTemplate.update(car);
		
	}

	@Transactional
	public void addCar(Car car) {
		this.hibernateTemplate.save(car);
		
	}

	@Transactional
	public void deleteCar(long carId) {
		Car car = this.getCarById(carId);
		this.hibernateTemplate.delete(car);
		
	}

}
