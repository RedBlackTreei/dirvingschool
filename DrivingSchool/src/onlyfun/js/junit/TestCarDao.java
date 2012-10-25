package onlyfun.js.junit;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import onlyfun.js.dao.CarDao;
import onlyfun.js.model.Car;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCarDao {

	ApplicationContext context = null;
	CarDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (CarDao)context.getBean("carDaoImpl");
	}
	
	@Test
	public void testGetCar(){
		Car car = (Car)dao.getCarById(1);
		System.out.println(car.getRemark());
		System.out.println(car.getPlateNum());
		System.out.println(car.getRegDate());
		System.out.println(car.getType());
	}
	
	@Test
	public void testGetCarByType(){
		List<Car> cars = dao.getCarByType("奥迪A6");
		
		for(Car car : cars){
			System.out.println(car.getRemark());
			System.out.println(car.getPlateNum());
			System.out.println(car.getRegDate());
			System.out.println(car.getType());
		}
	}
	
	@Test
	public void testGetCarByPlateNum(){
		Car car = dao.getCarByPlateNum("闽H354300");
		System.out.println(car.getRemark());
		System.out.println(car.getPlateNum());
		System.out.println(car.getRegDate());
		System.out.println(car.getType());
	}
	
	@Test
	public void testUpdate(){
		Car car = (Car)dao.getCarById(1);
		car.setRegDate(format.format(new Date()));
		dao.update(car);
	}
	
	@Test
	public void testAddCar(){
		Car car = new Car();
		car.setPlateNum("皖S65983");
		car.setType("BMW A8");
		car.setRegDate(format.format(new Date()));
		car.setRemark("此车很贵，小心使用");
		dao.addCar(car);
		//System.out.println(format.format(new Date()));
	}
	
	@Test
	public void testDelete(){
		dao.deleteCarById(3);
	}

	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

}
