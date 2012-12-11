package onlyfun.js.junit;

import static org.junit.Assert.*;

import onlyfun.js.model.Car;
import onlyfun.js.service.CarService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 项目名称：DrivingSchool  <br/>
 * 类名称：TestCarService  <br/>
 * 类描述：  <br/>
 * 创建人：js  <br/>
 * 创建时间：2012-12-11 下午3:56:06  <br/>
 * 修改人：js  <br/>
 * 修改时间：2012-12-11 下午3:56:06  <br/>
 * 修改备注：  <br/>
 * @version  
 */
public class TestCarService {

	ApplicationContext context = null;
	CarService cs = null;
	
	/**
	 * @throws java.lang.Exception
	 * void
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		cs = (CarService)context.getBean("carServiceImpl");
	}

	/**
	 * @throws java.lang.Exception
	 * void
	 */
	@After
	public void tearDown() throws Exception {
		context = null;
		cs = null;
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.CarServiceImpl#updateStu(onlyfun.js.model.Car, java.lang.String)}.
	 */
	@Test
	public final void testUpdateStu() {
		Car car = this.cs.getCarById(7);
		this.cs.updateStu(car, "3");
	}

	/**
	 * Test method for {@link onlyfun.js.service.impl.CarServiceImpl#updateCoach(onlyfun.js.model.Car, java.lang.String)}.
	 */
	@Test
	public final void testUpdateCoach() {
		Car car = this.cs.getCarById(7);
		System.out.println(car.getPlateNum());
		this.cs.updateCoach(car, "13");
	}

}
