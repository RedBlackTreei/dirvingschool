package onlyfun.js.junit;


import java.text.SimpleDateFormat;
import java.util.List;

import onlyfun.js.dao.CarDao;
import onlyfun.js.dao.CoachDao;
import onlyfun.js.model.Coach;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCoachDao {
	
	ApplicationContext context = null;
	CoachDao dao = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (CoachDao)context.getBean("coachDaoImpl");
	}

	@Test
	public void testGetCoach(){
		List<Coach> coach = dao.getCoach();
		for(Coach c : coach){
			System.out.println(c.getName());
		}
	}
	
	@Test
	public void testGetCoachById(){
		Coach coach = dao.getCoachById(1);
			System.out.println(coach.getName());
	}
	
	@Test
	public void testUpdate(){
		Coach coach = dao.getCoachById(1);
		//coach.setStuNum(3);
	}
	
	@After
	public void tearDown() throws Exception {
		context = null;
		dao = null;
	}

}
